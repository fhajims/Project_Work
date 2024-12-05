package com.birds.Birds.service.DataPopulatorService;

package thegame.coh2referenceapplication.service.DataPopulator;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import thegame.coh2referenceapplication.model.Faction;
import thegame.coh2referenceapplication.model.Soldier;
import thegame.coh2referenceapplication.model.Tank;
import thegame.coh2referenceapplication.model.Vehicle;
import thegame.coh2referenceapplication.service.ServiceInterfaces.IFactionService;
import thegame.coh2referenceapplication.service.ServiceInterfaces.ISoldierService;
import thegame.coh2referenceapplication.service.ServiceInterfaces.ITankService;
import thegame.coh2referenceapplication.service.ServiceInterfaces.IVehicleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataPopulatorService {

    private final IVehicleService vehicleService;
    private final ISoldierService soldierService;
    private final IFactionService factionService;
    private final ITankService tankService;

    @Transactional
    @PostConstruct
    public void populateDatabase() {

        List<Faction> persistedFactions = new ArrayList<>();


        List<Object[]> factionData = Arrays.asList(
                new Object[]{"Axis", "German", "A well balanced faction", "don´t know", "don´t know either", "http://localhost:8081/images/axis.png"},
                new Object[]{"Soviets", "Soviets", "A well balanced faction", "don´t know", "don´t know either", "http://localhost:8081/images/soviet.png"},
                new Object[]{"Wehrmacht", "German", "A well balanced faction", "don´t know", "don´t know either", "http://localhost:8081/images/wehrmacht.png"},
                new Object[]{"Americans", "America", "A well balanced faction", "don´t know", "don´t know either", "http://localhost:8081/images/usforces.png"},
                new Object[]{"Brits", "United Kingdom", "A well balanced faction", "don´t know", "don´t know either", "http://localhost:8081/images/brits.png"}
        );


        for (Object[] data : factionData) {
            Faction faction = new Faction();
            faction.setName((String) data[0]);
            faction.setNationality((String) data[1]);
            faction.setDescription((String) data[2]);
            faction.setWeaknesses((String) data[3]);
            faction.setStrengths((String) data[4]);
            faction.setFactionImage((String) data[5]);



            Faction savedFaction = factionService.addFaction(faction);
            persistedFactions.add(savedFaction);
        }


        List<Object[]> britishSoldiers = Arrays.asList(
                new Object[]{persistedFactions.get(4), "Infantry Section", 1000, 15, 10, 3.0, 2.0, 100.0, 50.0, 100.0, 75.0,
                        "Infantry", "Cannon", "High Armor", 0.05, 10, 200, 1.8, 2.0, "Factory",
                        "http://localhost:8081/images/infantry_section.png", "Du8HKHsOmjo", "Du8HKHsOmjo", ""},
                new Object[]{persistedFactions.get(4), "Vickers Heavy Machine Gun Team\n", 1000, 15, 10, 3.0, 2.0, 100.0, 50.0, 100.0, 75.0,
                        "Infantry", "Cannon", "High Armor", 0.05, 10, 200, 1.8, 2.0, "Factory",
                        "http://localhost:8081/images/vickers_heavy_machine_gun.png", "8ice2h1iZ2Q", "8ice2h1iZ2Q", ""},
                new Object[]{persistedFactions.get(4), "Royal Engineers\n", 1000, 15, 10, 3.0, 2.0, 100.0, 50.0, 100.0, 75.0,
                        "Infantry", "Cannon", "High Armor", 0.05, 10, 200, 1.8, 2.0, "Factory",
                        "http://localhost:8081/images/royal_engineers.png", "vmEg0zHkAbE", "vmEg0zHkAbE", ""}
        );

        List<Object[]> americanSoldiers = Arrays.asList(
                new Object[]{persistedFactions.get(4), "Riflemen", 1000, 15, 10, 3.0, 2.0, 100.0, 50.0, 100.0, 75.0,
                        "Infantry", "Cannon", "High Armor", 0.05, 10, 200, 1.8, 2.0, "Factory",
                        "http://localhost:8081/images/riflemen.png", "Du8HKHsOmjo", "Du8HKHsOmjo", ""},
                new Object[]{persistedFactions.get(4), "Rear Echelon Troops\n", 1000, 15, 10, 3.0, 2.0, 100.0, 50.0, 100.0, 75.0,
                        "Infantry", "Cannon", "High Armor", 0.05, 10, 200, 1.8, 2.0, "Factory",
                        "http://localhost:8081/images/rearechelontroops.png", "8ice2h1iZ2Q", "8ice2h1iZ2Q", ""},
                new Object[]{persistedFactions.get(4), "M1 81mm Mortar Team\n", 1000, 15, 10, 3.0, 2.0, 100.0, 50.0, 100.0, 75.0,
                        "Infantry", "Cannon", "High Armor", 0.05, 10, 200, 1.8, 2.0, "Factory",
                        "http://localhost:8081/images/Mortar_Team_Americans.png", "PPxJWOIP2Q4", "vmEg0zHkAbE", ""}
        );


        List<Object[]> tankData = Arrays.asList(
                new Object[]{persistedFactions.get(0), "Sdkfz 234 Puma Armored Car", 1000, 15, 10, 3.0, 2.0, 100.0, 50.0, 100.0, 75.0,
                        "Infantry", "Cannon", "High Armor", 0.05, 10, 200, 1.8, 2.0, "Factory",
                        "http://localhost:8081/images/puma.png", "yOJOg_BvyUY", "6uV8hZk9D8Y", "ein grooooßer Tank"},
                new Object[]{persistedFactions.get(0), "Panzer IV Ausf. J Medium Tank", 500, 12, 5, 5.0, 1.5, 75.0, 40.0, 50.0,
                        25.0, "Vehicles", "Machine Gun", "Speed", 0.1, 4, 100, 1.5, 1.8,
                        "Outpost", "http://localhost:8081/images/panzer4.png", "6uV8hZk9D8Y", "", "ein groooßerTank"}
        );

        List<Object[]> wehrmachtSoldiers = Arrays.asList(
                new Object[]{persistedFactions.get(2), "Heavy Infantry",
                        1000, 3, 10, 75.0, 100.0, 50.0, 0.8, 50.0, 30.0,
                        "Infantry", "Rifle", "Grenade", 10.0, 200, 150, 1.8, 1.5,
                        "Barracks", "http://localhost:8081/images/coh2.jpg", "",
                        "Elite Soldier", "Well-trained unit"},
                new Object[]{persistedFactions.get(2), "Light Infantry",
                        500, 5, 5, 40.0, 50.0, 30.0, 0.9, 30.0, 20.0,
                        "Vehicles", "Machine Gun", "Camouflage", 5.0,
                        100, 50, 1.6, 1.4, "Outpost", "http://localhost:8081/images/coh2.jpg",
                        "",  "Skilled Trooper", "Fast and agile"},
                new Object[]{persistedFactions.get(2), "Pioneer Squad",
                        200, 5, 5, 40.0, 50.0, 30.0, 0.9, 30.0, 20.0,
                        "Vehicles", "Machine Gun", "Camouflage", 5.0, 100,
                        50, 1.6, 1.4, "Outpost", "http://localhost:8081/images/pioneersquad.png",
                        "edFcmhQVYzM",  "Skilled Trooper", "Fast and agile"},
                new Object[]{persistedFactions.get(2), "MG42 Heavy Machinegun", 500,
                        5, 5, 40.0, 50.0, 30.0, 0.9, 30.0, 20.0, "Vehicles",
                        "Machine Gun", "Camouflage", 5.0, 100, 50, 1.6, 1.4,
                        "Outpost", "http://localhost:8081/images/mg42heavymachinegun.png",
                        "BZL1Bj5hfSE",  "Skilled Trooper", "Fast and agile"},
                new Object[]{persistedFactions.get(2), "Panzergrenadiers",
                        500, 5, 5, 40.0, 50.0, 30.0, 0.9, 30.0, 20.0, "Vehicles",
                        "Machine Gun", "Camouflage", 5.0, 100, 50, 1.6, 1.4, "Outpost",
                        "http://localhost:8081/images/panzergrenadiers.png", "SG0J-0jIv_s",
                        "Skilled Trooper", "Fast and agile"},
                new Object[]{persistedFactions.get(2), "Grenadiers",
                        500, 5, 5, 40.0, 50.0, 30.0, 0.9, 30.0, 20.0, "Vehicles",
                        "Kar98k", "Camouflage", 5.0, 100, 50, 1.6, 1.4, "Outpost",
                        "http://localhost:8081/images/grenadiers.png", "YiWdJV12h0k",
                        "Skilled Trooper", "Fast and agile"}
        );

        List<Object[]> vehicleDataList = Arrays.asList(
                new Object[]{persistedFactions.get(0), "SdKfz 250 Half-track", 800, 10, 20, 70.0, 60.0, 40.0, 1.0, 60.0, 40.0, "Vehicles", "Machine Gun", "Versatile", 5.0, 150, 100, 1.6, 1.4, "Garage", "http://localhost:8081/images/halftrack.png", "H_pDqulc_60",  "Sturmwagen", "Robust and reliable"},
                new Object[]{persistedFactions.get(0), "SdKfz 222 Scout Car", 600, 8, 15, 80.0, 50.0, 35.0, 1.2, 50.0, 30.0, "Vehicles", "Machine Gun", "Lightweight", 4.0, 100, 75, 1.4, 1.3, "Factory", "http://localhost:8081/images/scoutcar.png", "oqGTu-y5ZUA", "Jeep", "Fast and maneuverable"}
        );



        for (Object[] data : britishSoldiers) {

            Faction faction = persistedFactions.get(4);

            Soldier soldier = new Soldier();
            soldier.setFaction((Faction) faction);
            soldier.setDescription((String) data[1]);
            soldier.setCost((Integer) data[2]);
            soldier.setSightRange((Integer) data[3]);
            soldier.setStrength((Integer) data[4]);
            soldier.setSpeed((Double) data[5]);
            soldier.setReloadDuration((Double) data[6]);
            soldier.setDamageOnPenetration((Double) data[7]);
            soldier.setDamageOnNonPenetration((Double) data[8]);
            soldier.setArmorFront((Double) data[9]);
            soldier.setArmorBack((Double) data[10]);
            soldier.setEffectiveAgainst((String) data[11]);
            soldier.setWeapon((String) data[12]);
            soldier.setAdvantage((String) data[13]);
            soldier.setDodge((Double) data[14]);
            soldier.setSquadStrength((Integer) data[15]);
            soldier.setReinforceCost((Integer) data[16]);
            soldier.setReloadDurationVeterancy((Double) data[17]);
            soldier.setVeterancyBenefits((Double) data[18]);
            soldier.setBuildsIn((String) data[19]);
            soldier.setImageUrl((String) data[20]);
            soldier.setYoutubeLink((String) data[21]);
            soldier.setSoldierMiscellaneous((String) data[22]);
            soldier.setSoldierTactics((String) data[23]);


            soldierService.addSoldier(soldier);
        }

        for (Object[] data : americanSoldiers) {

            Faction faction = persistedFactions.get(3);

            Soldier soldier = new Soldier();
            soldier.setFaction((Faction) faction);
            soldier.setDescription((String) data[1]);
            soldier.setCost((Integer) data[2]);
            soldier.setSightRange((Integer) data[3]);
            soldier.setStrength((Integer) data[4]);
            soldier.setSpeed((Double) data[5]);
            soldier.setReloadDuration((Double) data[6]);
            soldier.setDamageOnPenetration((Double) data[7]);
            soldier.setDamageOnNonPenetration((Double) data[8]);
            soldier.setArmorFront((Double) data[9]);
            soldier.setArmorBack((Double) data[10]);
            soldier.setEffectiveAgainst((String) data[11]);
            soldier.setWeapon((String) data[12]);
            soldier.setAdvantage((String) data[13]);
            soldier.setDodge((Double) data[14]);
            soldier.setSquadStrength((Integer) data[15]);
            soldier.setReinforceCost((Integer) data[16]);
            soldier.setReloadDurationVeterancy((Double) data[17]);
            soldier.setVeterancyBenefits((Double) data[18]);
            soldier.setBuildsIn((String) data[19]);
            soldier.setImageUrl((String) data[20]);
            soldier.setYoutubeLink((String) data[21]);
            soldier.setSoldierMiscellaneous((String) data[22]);
            soldier.setSoldierTactics((String) data[23]);


            soldierService.addSoldier(soldier);
        }







        for (Object[] data : wehrmachtSoldiers) {

            Faction faction = persistedFactions.get(2);

            Soldier soldier = new Soldier();
            soldier.setFaction((Faction) faction);
            soldier.setDescription((String) data[1]);
            soldier.setCost((Integer) data[2]);
            soldier.setSightRange((Integer) data[3]);
            soldier.setStrength((Integer) data[4]);
            soldier.setSpeed((Double) data[5]);
            soldier.setReloadDuration((Double) data[6]);
            soldier.setDamageOnPenetration((Double) data[7]);
            soldier.setDamageOnNonPenetration((Double) data[8]);
            soldier.setArmorFront((Double) data[9]);
            soldier.setArmorBack((Double) data[10]);
            soldier.setEffectiveAgainst((String) data[11]);
            soldier.setWeapon((String) data[12]);
            soldier.setAdvantage((String) data[13]);
            soldier.setDodge((Double) data[14]);
            soldier.setSquadStrength((Integer) data[15]);
            soldier.setReinforceCost((Integer) data[16]);
            soldier.setReloadDurationVeterancy((Double) data[17]);
            soldier.setVeterancyBenefits((Double) data[18]);
            soldier.setBuildsIn((String) data[19]);
            soldier.setImageUrl((String) data[20]);
            soldier.setYoutubeLink((String) data[21]);
            soldier.setSoldierMiscellaneous((String) data[22]);
            soldier.setSoldierTactics((String) data[23]);


            soldierService.addSoldier(soldier);
        }




        for (Object[] data : tankData) {
            Faction faction = persistedFactions.get(0);
            Tank tank = new Tank();
            tank.setFaction((Faction) faction);
            tank.setDescription((String) data[1]);
            tank.setCost((Integer) data[2]);
            tank.setSightRange((Integer) data[3]);
            tank.setStrength((Integer) data[4]);
            tank.setSpeed((Double) data[5]);
            tank.setReloadDuration((Double) data[6]);
            tank.setDamageOnPenetration((Double) data[7]);
            tank.setDamageOnNonPenetration((Double) data[8]);
            tank.setArmorFront((Double) data[9]);
            tank.setArmorBack((Double) data[10]);
            tank.setEffectiveAgainst((String) data[11]);
            tank.setWeapon((String) data[12]);
            tank.setAdvantage((String) data[13]);
            tank.setDodge((Double) data[14]);
            tank.setSquadStrength((Integer) data[15]);
            tank.setReinforceCost((Integer) data[16]);
            tank.setReloadDurationVeterancy((Double) data[17]);
            tank.setVeterancyBenefits((Double) data[18]);
            tank.setBuildsIn((String) data[19]);
            tank.setImageUrl((String) data[20]);
            tank.setYoutubeLink((String) data[21]);
            tank.setTankMiscellaneous((String) data[22]);
            tank.setTankTactics((String) data[23]);


            tankService.addTank(tank);
        }

        for (Object[] data : vehicleDataList) {
            Faction faction = persistedFactions.get(0);
            Vehicle vehicle = new Vehicle();
            vehicle.setFaction((persistedFactions.get(0)));
            vehicle.setDescription((String) data[1]);
            vehicle.setCost((Integer) data[2]);
            vehicle.setSightRange((Integer) data[3]);
            vehicle.setStrength((Integer) data[4]);
            vehicle.setSpeed((Double) data[5]);
            vehicle.setReloadDuration((Double) data[6]);
            vehicle.setDamageOnPenetration((Double) data[7]);
            vehicle.setDamageOnNonPenetration((Double) data[8]);
            vehicle.setArmorFront((Double) data[9]);
            vehicle.setArmorBack((Double) data[10]);
            vehicle.setEffectiveAgainst((String) data[11]);
            vehicle.setWeapon((String) data[12]);
            vehicle.setAdvantage((String) data[13]);
            vehicle.setDodge((Double) data[14]);
            vehicle.setSquadStrength((Integer) data[15]);
            vehicle.setReinforceCost((Integer) data[16]);
            vehicle.setReloadDurationVeterancy((Double) data[17]);
            vehicle.setVeterancyBenefits((Double) data[18]);
            vehicle.setBuildsIn((String) data[19]);
            vehicle.setImageUrl((String) data[20]);
            vehicle.setYoutubeLink((String) data[21]);
            vehicle.setVehicleMiscellaneous((String) data[22]);
            vehicle.setVehicleTactics((String) data[23]);


            vehicleService.addVehicle(vehicle);
        }

    }




}
