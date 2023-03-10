package net.mcreator.pentamorph.procedures;

import net.mcreator.pentamorph.PentamorphMod;
import net.mcreator.pentamorph.client.renderer.QuintessonJurorRenderer;
import net.mcreator.pentamorph.entity.QuintessonJurorEntity;
import net.mcreator.pentamorph.init.PentamorphModEntityRenderers;
import net.mcreator.pentamorph.init.PentamorphModEntities;
import net.mcreator.pentamorph.network.PentamorphModVariables;


import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RenderPlayerEvent.Pre;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
//import net.minecraftforge.client.event.RenderLivingEvent.Pre;



@Mod.EventBusSubscriber(value=Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class QuintusTokenRightclickedOnBlockProcedure {

	//
	@SubscribeEvent
	public static void onPlayerTick(RenderPlayerEvent.Pre event){
		renderShift(event);
	}
	/*
	//initial execution
	@SubscribeEvent
	public static void execute(ItemStack itemstack) {	
		RenderPlayerEvent.Pre event;
		//Player player = event.getEntity();
		if((itemstack.getOrCreateTag().getString("character")).equals("Juror")){
			//event.setCanceled(true);
			String character = "Juror";
			renderShift(event, character);
		}
	}
*/
	//render change
	@SubscribeEvent
	public static void renderShift(RenderPlayerEvent.Pre event){
		Entity entity = event.getEntity();
		if((entity.getCapability(PentamorphModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PentamorphModVariables.PlayerVariables())).formFinal == false){
			//test condition
			if (((entity.getCapability(PentamorphModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PentamorphModVariables.PlayerVariables())).characterType).equals("Juror")) {
				//Player player = event.getEntity();
				event.setCanceled(true);
				EntityRendererProvider.Context context = new EntityRendererProvider.Context(				
					Minecraft.getInstance().getEntityRenderDispatcher(),
    	      		Minecraft.getInstance().getItemRenderer(),
       		  		Minecraft.getInstance().getBlockRenderer(),
        			Minecraft.getInstance().gameRenderer.itemInHandRenderer,
        			Minecraft.getInstance().getResourceManager(),
	      		  	Minecraft.getInstance().getEntityModels(),
    	    		Minecraft.getInstance().font
        		);
				event.getPoseStack().pushPose();
				//custom renderer
				
				
				//Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(ent).render();
				event.getPoseStack().popPose();
			}
			//conditional2
			//conditional3
			
			//
		}
	}
}


