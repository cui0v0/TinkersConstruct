package slimeknights.tconstruct.tools.data;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import slimeknights.tconstruct.library.materials.IMaterial;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialId;

import java.util.ArrayList;
import java.util.List;

final class Materials {

  static final List<IMaterial> allMaterials = new ArrayList<>();

  //Tier 1
  public static final IMaterial wood = mat(MaterialIds.wood, Fluids.EMPTY, true, "8e661b");
  public static final IMaterial bone = mat(MaterialIds.bone, Fluids.EMPTY, true, "ede6bf");
  public static final IMaterial stone = mat(MaterialIds.stone, Fluids.EMPTY, true, "999999");
  public static final IMaterial paper = mat(MaterialIds.paper, Fluids.EMPTY, true, "ffffff");

  //Tier 2
  public static final IMaterial copper = mat(MaterialIds.copper, Fluids.EMPTY, false, "ed9f07");
  public static final IMaterial searedstone = mat(MaterialIds.searedstone, Fluids.EMPTY, false, "ed9f07");
  public static final IMaterial iron = mat(MaterialIds.iron, Fluids.EMPTY, false, "cacaca");
  public static final IMaterial slimewood = mat(MaterialIds.slimewood, Fluids.EMPTY, false, "82c873");
  public static final IMaterial slimestone = mat(MaterialIds.slimestone, Fluids.EMPTY, false, "82c873");

  //Tier 2 alternate
  public static final IMaterial mushwood = mat(MaterialIds.mushwood, Fluids.EMPTY, true, "24bad5");
  public static final IMaterial bloodwood = mat(MaterialIds.bloodwood, Fluids.EMPTY, true, "d53024");
  public static final IMaterial netherrack = mat(MaterialIds.netherrack, Fluids.EMPTY, true, "b84f4f");
  public static final IMaterial blackstone = mat(MaterialIds.blackstone, Fluids.EMPTY, true, "333333");
  public static final IMaterial basalt = mat(MaterialIds.basalt, Fluids.EMPTY, true, "cfcfcf");
  public static final IMaterial quartzite = mat(MaterialIds.quartzite, Fluids.EMPTY, true, "efefef");

  //Tier 3
  public static final IMaterial slimesteel = mat(MaterialIds.slimesteel, Fluids.EMPTY, false, "74c8c7");
  public static final IMaterial nauhatl = mat(MaterialIds.nauhatl, Fluids.EMPTY, false, "601cc4");
  public static final IMaterial bronze = mat(MaterialIds.bronze, Fluids.EMPTY, false, "e3bd68");
  public static final IMaterial slimebronze = mat(MaterialIds.slimebronze, Fluids.EMPTY, false, "e3bd68");
  public static final IMaterial pigiron = mat(MaterialIds.pigiron, Fluids.EMPTY, false, "ef9e9b");
  public static final IMaterial rosegold = mat(MaterialIds.rosegold, Fluids.EMPTY, false, "ff5a89");

  public static final IMaterial cobalt = mat(MaterialIds.cobalt, Fluids.EMPTY, false, "2882d4");
  public static final IMaterial endstone = mat(MaterialIds.endstone, Fluids.EMPTY, true, "e0d890");

  //Tier 4
  public static final IMaterial soulsteel = mat(MaterialIds.soulsteel, Fluids.EMPTY, true, "6a3723");
  public static final IMaterial obsidianbronze = mat(MaterialIds.obsidianbronze, Fluids.EMPTY, true, "601cc4");
  public static final IMaterial blazewood = mat(MaterialIds.blazewood, Fluids.EMPTY, true, "e0d890");

  //Tier 5
  public static final IMaterial manyullyn = mat(MaterialIds.manyullyn, Fluids.EMPTY, false, "a15cf8");
  public static final IMaterial knightslime = mat(MaterialIds.knightslime, Fluids.EMPTY, false, "f18ff0");

  private static IMaterial mat(MaterialId location, Fluid fluid, boolean craftable, String materialColor) {
    Material material = new Material(location, fluid, craftable, materialColor);
    allMaterials.add(material);
    return material;
  }

  private Materials() {
  }
}
