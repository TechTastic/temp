package io.github.techtastic.valkyrien_computers.util;

import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;

import java.util.Map;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class ShipIntegrationMethods {

    public static Map<String, Double> getRotationAsRPY(ServerShip ship) {
        Vector3d rpy = convertQuaternionToRPY(ship.getTransform().getShipToWorldRotation());
        return Map.of("roll", rpy.x, "pitch", rpy.y, "yaw", rpy.z);
    }

    public static Map<String, Double> getRotationAsQuaternion(ServerShip ship) {
        Quaterniondc q = ship.getTransform().getShipToWorldRotation();
        return Map.of("x", q.x(), "y", q.y(), "z", q.z(), "w", q.w());
    }

    public static Map<String, Double> getVelocityFromShip(ServerShip ship) {
        Vector3dc vel = ship.getVelocity();
        return Map.of("x", vel.x(), "y", vel.y(), "z", vel.z());
    }

    public static Map<String, Double> getCenterOfMassInWorld(ServerShip ship) {
        Vector3dc com = ship.getTransform().getPositionInWorld();
        return Map.of("x", com.x(), "y", com.y(), "z", com.z());
    }

    public static Map<String, Double> getCenterOfMassInShip(ServerShip ship) {
        Vector3dc com = ship.getTransform().getPositionInShip();
        return Map.of("x", com.x(), "y", com.y(), "z", com.z());
    }

    public static String getNameFromShip(ServerShip ship) {
        return ((ShipDataCommon) ship).getName();
    }

    public static void setNameForShip(ServerShip ship, String name) {
        ((ShipDataCommon) ship).setName(name);
    }

    public static Map<String, Double> getScaleFromShip(ServerShip ship) {
        Vector3dc scale = ship.getTransform().getShipToWorldScaling();
        return Map.of("x", scale.x(), "y", scale.y(), "z", scale.z());
    }

    public static Long getIdFromShip(ServerShip ship) {
        return ship.getId();
    }

    public static Double getMassFromShip(ServerShip ship) {
        return ship.getInertiaData().getMass();
    }

    public static Map<String, Integer> getSizeFromShip(ServerShip ship) {
        AABBic aabb = ship.getShipAABB();
        if (aabb == null)
            return null;
        return Map.of("x", aabb.maxX() - aabb.minX(),
                "y", aabb.maxY() - aabb.minY(),
                "z", aabb.maxZ() - aabb.minZ());
    }

    public static Vector3d convertQuaternionToRPY(Quaterniondc q) {
        return  new Vector3d(atan2(2 * (q.w() * q.x() + q.y() * q.z()), 1 - 2 * (q.x() * q.x() + q.y() * q.y())),
                2 * atan2(sqrt(1 + 2 * (q.w() * q.y() - q.x() * q.z())), sqrt(1 - 2 * (q.w() * q.y() - q.x() * q.z()))) - Math.PI / 2,
                atan2(2 * (q.w() * q.z() + q.x() * q.y()), 1 - 2 * (q.y() * q.y() + q.z() * q.z())));
    }
}
