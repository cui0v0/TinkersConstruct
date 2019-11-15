package slimeknights.tconstruct.library.materials;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.exception.TinkerJSONException;
import slimeknights.tconstruct.library.materials.json.MaterialJson;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Loads the material data from datapacks and provides them to whatever needs them.
 * Contains only the very basic material information, craftability, traits, but no stats.
 * See {@link slimeknights.tconstruct.library.materials.stats.MaterialStatsManager} for stats.
 *
 * The location inside datapacks is "materials".
 * So if your mods name is "foobar", the location for your mods materials is "data/foobar/materials".
 */
public class MaterialManager extends JsonReloadListener {

  private static final Logger LOGGER = LogManager.getLogger();

  @VisibleForTesting
  protected static final String FOLDER = "materials";
  @VisibleForTesting
  protected static final Gson GSON = (new GsonBuilder())
    .registerTypeAdapter(ResourceLocation.class, new ResourceLocation.Serializer())
    .setPrettyPrinting()
    .disableHtmlEscaping()
    .create();

  private Map<ResourceLocation, IMaterial> materials = ImmutableMap.of();

  public MaterialManager() {
    super(GSON, FOLDER);
  }

  public Collection<IMaterial> getAllMaterials() {
    return materials.values();
  }

  @Override
  protected void apply(Map<ResourceLocation, JsonObject> splashList, IResourceManager resourceManagerIn, IProfiler profilerIn) {
    materials = splashList.entrySet().stream()
      .map(entry -> loadMaterial(entry.getKey(), entry.getValue()))
      .filter(Objects::nonNull)
      .collect(Collectors.toMap(
        IMaterial::getIdentifier,
        material -> material)
      );
  }

  @Nullable
  private IMaterial loadMaterial(ResourceLocation materialId, JsonObject jsonObject) {
    try {
      MaterialJson materialJson = GSON.fromJson(jsonObject, MaterialJson.class);

      if(materialJson.getCraftable() == null) {
        throw TinkerJSONException.materialJsonWithoutRequiredData(materialId);
      }

      boolean isCraftable = Boolean.TRUE.equals(materialJson.getCraftable());
      Fluid fluid = loadFluid(materialId, materialJson);
      ItemStack shard = loadShardItem(materialId, materialJson);

      return new Material(materialId, fluid, isCraftable, shard);
    } catch (Exception e) {
      LOGGER.error("Could not deserialize material {}. JSON: {}", materialId, jsonObject, e);
      return null;
    }
  }

  private ItemStack loadShardItem(ResourceLocation materialId, MaterialJson materialJson) {
    ResourceLocation shardItemId = materialJson.getShardItem();
    ItemStack shard = ItemStack.EMPTY;
    if(shardItemId != null) {
      Item shardItem = ForgeRegistries.ITEMS.getValue(shardItemId);
      // air is the default, but the contract also allows null
      if(shardItem != null && shardItem != Items.AIR) {
        shard = new ItemStack(shardItem);
      } else {
        LOGGER.warn("Could not find shard item {} for material {}", shardItemId, materialId);
      }
    }
    return shard;
  }

  private Fluid loadFluid(ResourceLocation materialId, MaterialJson materialJson) {
    ResourceLocation fluidId = materialJson.getFluid();
    Fluid fluid = Fluids.EMPTY;
    if (fluidId != null) {
      fluid = ForgeRegistries.FLUIDS.getValue(fluidId);
      if (fluid == null || fluid.getDefaultState().isEmpty()) {
        LOGGER.warn("Could not find fluid {} for material {}", fluidId, materialId);
        fluid = Fluids.EMPTY;
      }
    }
    return fluid;
  }

}
