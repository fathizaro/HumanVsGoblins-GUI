package java.Events;

import Entities.Character;
import Managers.EventManager;
import Utils.Events;

//Event triggered whenever a character is damaged
public class DamageEvent {
    public Character target;
    public Character instigator;
    public int damage;

    //Initialize with target, attacker and damage done (-1 damage means attack missed)
    public DamageEvent (Character target, Character instigator, int damage) {
        this.target = target;
        this.instigator = instigator;
        this.damage = damage;
    }

    //Static Event Object
    static DamageEvent e;

    //called to trigger this event
    public static void Trigger(Character target, Character instigator, int damage) {
        e = new DamageEvent(target, instigator, damage);
        EventManager.TriggerEvent(e, Events.DamageEvent);
    }
}