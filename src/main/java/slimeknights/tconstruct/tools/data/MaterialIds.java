package slimeknights.tconstruct.tools.data;

import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.MaterialId;

public final class MaterialIds {

  //Tier 1
  public static final MaterialId wood = id("wood");
  public static final MaterialId bone = id("bone");
  public static final MaterialId stone = id("stone");
  public static final MaterialId paper = id("paper");

  //Tier 2
  public static final MaterialId copper = id("copper");
  public static final MaterialId searedstone = id("searedstone");
  public static final MaterialId iron = id("iron");
  public static final MaterialId slimewood = id("slimewood");
  public static final MaterialId slimestone = id("slimestone");

  //Tier 2 alternate
  public static final MaterialId mushwood = id("mushwood");
  public static final MaterialId bloodwood = id("bloodwood");
  public static final MaterialId netherrack = id("netherrack");
  public static final MaterialId blackstone = id("blackstone");
  public static final MaterialId basalt = id("basalt");
  public static final MaterialId quartzite = id("quartzite");

  //Tier 3
  public static final MaterialId slimesteel = id("slimesteel");
  public static final MaterialId nauhatl = id("nauhatl");
  public static final MaterialId bronze = id("bronze");
  public static final MaterialId slimebronze = id("slimebronze");
  public static final MaterialId pigiron = id("pigiron");
  public static final MaterialId rosegold = id("rosegold");

  public static final MaterialId cobalt = id("cobalt");
  public static final MaterialId endstone = id("endstone");

  //Tier 4
  public static final MaterialId soulsteel = id("soulsteel");
  public static final MaterialId obsidianbronze = id("obsidianbronze");
  public static final MaterialId blazewood = id("blazewood");

  //Tier 5
  public static final MaterialId manyullyn = id("manyullyn");
  public static final MaterialId knightslime = id("knightslime");

  //Mod integration
  //public static final MaterialId lead = id("lead");
  //public static final MaterialId silver = id("silver");
  //public static final MaterialId electrum = id("electrum");
  //public static final MaterialId steel = id("steel");

  //Unused
  //public static final MaterialId flint = id("flint");
  //public static final MaterialId cactus = id("cactus");
  //public static final MaterialId obsidian = id("obsidian");
  //public static final MaterialId prismarine = id("prismarine");
  //public static final MaterialId sponge = id("sponge");
  //public static final MaterialId firewood = id("firewood");

  // Slime
  //public static final MaterialId slime = id("slime");
  //public static final MaterialId blueslime = id("blueslime");
  //public static final MaterialId magmaslime = id("magmaslime");

  // Metals

  // Nether Materials
  //public static final MaterialId ardite = id("ardite");

  // mod integration

  // bowstring materials
  //public static final MaterialId string = id("string");
  //public static final MaterialId vine = id("vine");
  //public static final MaterialId slimevine_blue = id("slimevine_blue");
  //public static final MaterialId slimevine_purple = id("slimevine_purple");

  // additional arrow shaft
  //public static final MaterialId blaze = id("blaze");
  //public static final MaterialId reed = id("reed");
  //public static final MaterialId ice = id("ice");
  //public static final MaterialId endrod = id("endrod");

  // fletching
  //public static final MaterialId feather = id("feather");
  //public static final MaterialId leaf = id("leaf");
  //public static final MaterialId slimeleaf_blue = id("slimeleaf_blue");
  //public static final MaterialId slimeleaf_orange = id("slimeleaf_orange");
  //public static final MaterialId slimeleaf_purple = id("slimeleaf_purple");

  private static MaterialId id(String name) {
    return new MaterialId(Util.getResource(name));
  }

  private MaterialIds() {
  }
}
