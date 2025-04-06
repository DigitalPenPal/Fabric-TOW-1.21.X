package net.pencil.tow.entity.custom;


import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class NutcrackerSoldier1Entity extends HostileEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    protected NutcrackerSoldier1Entity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new MeleeAttackGoal(this, 2.0, false));
        this.goalSelector.add(1, new WanderNearTargetGoal(this, 0.9, 30.0f));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 10));

        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal(this, MobEntity.class, 5, true,
                true, entity -> entity instanceof Monster && !(entity instanceof NutcrackerSoldier1Entity)));
        this.targetSelector.add(3, new ActiveTargetGoal(this, HostileEntity.class, true,
                true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, GolemEntity.class, true,
                true));

        this.goalSelector.add(2, new WanderAroundGoal(this, 0.3));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 5.0f));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }
}