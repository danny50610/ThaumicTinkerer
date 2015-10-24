package com.nekokittygames.Thaumic.Tinkerer.common.research

import com.nekokittygames.Thaumic.Tinkerer.client.libs.LibResources
import com.nekokittygames.Thaumic.Tinkerer.common.blocks.quartz.BlockDarkQuartz
import com.nekokittygames.Thaumic.Tinkerer.common.items.{ItemCometBoots, ItemMobAspect}
import com.nekokittygames.Thaumic.Tinkerer.common.items.baubles.{ItemEnderDisruption, ItemStabilizerBelt}
import com.nekokittygames.Thaumic.Tinkerer.common.items.quartz.ItemDarkQuartz
import com.nekokittygames.Thaumic.Tinkerer.common.libs.LibResearch
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraft.util.ResourceLocation
import thaumcraft.api.aspects.{Aspect, AspectList}
import thaumcraft.api.crafting.InfusionRecipe
import thaumcraft.api.research.{ResearchCategories, ResearchPage}
import thaumcraft.common.config.ConfigResearch

/**
 * Created by fiona on 22/05/2015.
 */
object ModResearch {


  def registerResearch() = {
    registerResearchPage()

    var research: TTResearchItem=null

    research=new TTResearchItem(LibResearch.KEY_DARK_QUARTZ,new AspectList(),-2,2,0,new ItemStack(ItemDarkQuartz),new ResearchPage("0"),recipePage(LibResearch.KEY_DARK_QUARTZ+0)).registerResearchItem().asInstanceOf[TTResearchItem]

    research=new TTResearchItem(LibResearch.KEY_DARK_QUARTZ_BLOCKS,new AspectList(),-3,0,0,new ItemStack(BlockDarkQuartz),new ResearchPage("0"),recipePage(LibResearch.KEY_DARK_QUARTZ_BLOCKS+0),recipePage(LibResearch.KEY_DARK_QUARTZ_BLOCKS+1),recipePage(LibResearch.KEY_DARK_QUARTZ_BLOCKS+2)).setParents(LibResearch.KEY_DARK_QUARTZ).registerResearchItem().asInstanceOf[TTResearchItem]
    research=new TTResearchItem(LibResearch.KEY_STABILIZER_BELT,new AspectList().add(Aspect.ORDER, 4).add(Aspect.EARTH, 4).add(Aspect.MOTION, 2),1,-10,1,new ItemStack(ItemStabilizerBelt),new ResearchPage("0"),infusionPage(LibResearch.KEY_STABILIZER_BELT+0)).setParentsHidden("INFUSION").registerResearchItem().asInstanceOf[TTResearchItem]
    research=new TTResearchItem(LibResearch.KEY_ENDER_DISRUPTER,new AspectList().add(Aspect.FLUX, 4).add(Aspect.EXCHANGE, 4).add(Aspect.ELDRITCH, 2),2,-9,2,new ItemStack(ItemEnderDisruption),new ResearchPage("0"),infusionPage(LibResearch.KEY_ENDER_DISRUPTER+0)).setParentsHidden("INFUSION").registerResearchItem().asInstanceOf[TTResearchItem]
    research=new TTResearchItem(LibResearch.KEY_COMET_BOOTS,new AspectList().add(Aspect.WATER, 5).add(Aspect.COLD, 5).add(Aspect.FLIGHT, 10).add(Aspect.MOTION, 5),5,-3,2,new ItemStack(ItemCometBoots),new ResearchPage("0"),infusionPage(LibResearch.KEY_COMET_BOOTS+0)).setParentsHidden("INFUSION").setParents("FOCUSFROST").setParents("BOOTSTRAVELLER").registerResearchItem().asInstanceOf[TTResearchItem]
    val itemStack=new ItemStack(ItemMobAspect)
    ItemMobAspect.setAspect(itemStack,Aspect.LIFE)
    research=new TTResearchItem(LibResearch.KEY_MOB_SUMMON,new AspectList().add(Aspect.DEATH, 4).add(Aspect.LIFE, 4).add(Aspect.UNDEAD, 2),0,0,2,itemStack,new ResearchPage("0"),recipePage(LibResearch.KEY_MOB_SUMMON+1),new ResearchPage("2"),infusionPage(LibResearch.KEY_MOB_SUMMON+2)).setParentsHidden("INFUSION").registerResearchItem().asInstanceOf[TTResearchItem]
  }

  def registerResearchPage() = {
    ResearchCategories.registerCategory(LibResearch.CATEGORY_THAUMICTINKERER,null, new ResourceLocation(LibResources.MISC_R_ENCHANTING), new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_3.jpg"))
    ResearchCategories.registerCategory(LibResearch.CATEGORY_THAUMICTINKERERKAMI,LibResearch.KEY_KAMI, new ResourceLocation(LibResources.MISC_R_ENCHANTING), new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_3.jpg"))
  }


  def recipePage(name:String):ResearchPage ={
    new ResearchPage(ConfigResearch.recipes.get(name).asInstanceOf[IRecipe])
  }


  def infusionPage(name:String)=
  {
    new ResearchPage(ConfigResearch.recipes.get(name).asInstanceOf[InfusionRecipe])
  }
}