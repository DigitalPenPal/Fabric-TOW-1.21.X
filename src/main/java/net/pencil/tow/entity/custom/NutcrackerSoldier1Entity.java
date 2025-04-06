package net.pencil.tow.entity.custom;


import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
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

    public NutcrackerSoldier1Entity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new MeleeAttackGoal(this, 2.0, false));
        this.goalSelector.add(1, new WanderNearTargetGoal(this, 0.3, 30.0f));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 10));

        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal(this, HostileEntity.class, 5, true,
                true, entity -> !(entity instanceof NutcrackerSoldier1Entity)));
        this.targetSelector.add(3, new ActiveTargetGoal(this, MobEntity.class, true,
                true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, GolemEntity.class, true,
                true));
        this.targetSelector.add(5, new ActiveTargetGoal(this, PlayerEntity.class, true,
                true));

        this.goalSelector.add(2, new WanderAroundGoal(this, 0.3));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 5.0f));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, 50)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.5);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    protected int getNextAirUnderwater(int air) {
        return super.getNextAirUnderwater(air);
    }


}