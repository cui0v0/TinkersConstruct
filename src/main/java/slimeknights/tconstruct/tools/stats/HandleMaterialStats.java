package slimeknights.tconstruct.tools.stats;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.renderer.font.CustomFontColor;
import slimeknights.tconstruct.library.materials.stats.BaseMaterialStats;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class HandleMaterialStats extends BaseMaterialStats {

  public static final MaterialStatsId ID = new MaterialStatsId(Util.getResource("handle"));
  public static final HandleMaterialStats DEFAULT = new HandleMaterialStats(0, 1f, 1f, 1f);

  public final static String MULTIPLIER_LOCALIZATION = "stat.handle.durability.multiplier.name";
  public final static String DURABILITY_LOCALIZATION = "stat.handle.durability.base.name";
  public final static String ATTACK_SPEED_LOCALIZATION = "stat.handle.speed.attack.name";
  public final static String MINING_SPEED_LOCALIZATION = "stat.handle.speed.mining.name";

  public final static String MULTIPLIER_DESCRIPTION_LOCALIZATION = "stat.handle.durability.multiplier.description";
  public final static String DURABILITY_DESCRIPTION_LOCALIZATION = "stat.handle.durability.base.description";
  public final static String ATTACK_SPEED_DESCRIPTION_LOCALIZATION = "stat.handle.speed.attack.description";
  public final static String MINING_SPEED_DESCRIPTION_LOCALIZATION = "stat.handle.speed.mining.description";

  public final static String DURABILITY_COLOR = HeadMaterialStats.DURABILITY_COLOR;
  public final static String MODIFIER_COLOR = CustomFontColor.encodeColor(185, 185, 90);

  private int durability;
  private float durabilityMultiplier;
  private float miningSpeedMultiplier;
  private float attackSpeedMultiplier;

  @Override
  public void encode(PacketBuffer buffer) {
    buffer.writeInt(this.durability);
    buffer.writeFloat(this.durabilityMultiplier);
    buffer.writeFloat(this.miningSpeedMultiplier);
    buffer.writeFloat(this.attackSpeedMultiplier);
  }

  @Override
  public void decode(PacketBuffer buffer) {
    this.durability = buffer.readInt();
    this.durabilityMultiplier = buffer.readFloat();
    this.miningSpeedMultiplier = buffer.readFloat();
    this.attackSpeedMultiplier = buffer.readFloat();
  }

  @Override
  public MaterialStatsId getIdentifier() {
    return ID;
  }

  @Override
  public List<ITextComponent> getLocalizedInfo() {
    return ImmutableList.of(formatModifier(this.durabilityMultiplier),formatDurability(this.durability));
  }

  @Override
  public List<ITextComponent> getLocalizedDescriptions() {
    return ImmutableList.of(new TranslationTextComponent(MULTIPLIER_DESCRIPTION_LOCALIZATION), new TranslationTextComponent(DURABILITY_DESCRIPTION_LOCALIZATION));
  }


  public static ITextComponent formatModifier(float quality) {
    return formatNumber(MULTIPLIER_LOCALIZATION, MODIFIER_COLOR, quality);
  }

  public static ITextComponent formatDurability(int durability) {
    return formatNumber(DURABILITY_LOCALIZATION, DURABILITY_COLOR, durability);
  }
}
