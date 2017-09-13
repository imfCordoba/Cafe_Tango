package com.madrefoca.cafe_tango.Utils;

import android.util.Log;
import com.j256.ormlite.dao.Dao;
import com.madrefoca.cafe_tango.helpers.DatabaseHelper;
import com.madrefoca.cafe_tango.model.Illness;
import com.madrefoca.cafe_tango.model.IllnessSchoolHouse;
import com.madrefoca.cafe_tango.model.SchoolHouse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by fernando on 27/08/17.
 */

public class DatabasePopulatorUtil {
    private DatabaseHelper databaseHelper = null;

    public DatabasePopulatorUtil() {
    }

    public DatabasePopulatorUtil(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void populate(){
        this.insertSomeIllnessesAndSchools();
    }

    private void insertSomeIllnessesAndSchools() {
        Log.d("DatabasePopulatorUtil: ", "insertSomeIllnessesAndSchools()");

        try {
            // This is how, a reference of DAO object can be done
            final Dao<Illness, Integer> illnessDao = databaseHelper.getIllnesDao();

            ArrayList<Illness> illnessesArrayList = new ArrayList<Illness>();
            illnessesArrayList.add(new Illness("Cáncer de piel", "otro tipo de cancer de piel"));
            illnessesArrayList.add(new Illness("Cáncer de mama", "otro tipo de cancer de mama"));
            illnessesArrayList.add(new Illness("Cáncer de próstata", "otro tipo de cancer de prostata"));
            illnessesArrayList.add(new Illness("Cáncer de hígado", "mucho vino da este cancer"));
            illnessesArrayList.add(new Illness("Cáncer de páncreas", "ese cancer que no se por que da"));
            illnessesArrayList.add(new Illness("Cáncer de huesos", "un tipo de cancer jodido que quedas deforme"));
            illnessesArrayList.add(new Illness("Resfrío", "resfrio normal dar aspirina"));
            illnessesArrayList.add(new Illness("Migraña", "un dolor de cabeza jodido"));

            for(Illness illness: illnessesArrayList){
                //This is the way to insert data into a database table
                illnessDao.create(illness);
                String log = "Illness " + illness.getIllnessName() + ", saved in database. " ;
                // Writing Illness to log
                Log.d("DatabasePopulatorUtil: ", log);
                this.createSchoolsForIllness(illness);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createSchoolsForIllness(Illness illness){
        String illnessName = illness.getIllnessName();
        ArrayList<SchoolHouse> schoolHouseArrayList = new ArrayList<>();
        switch (illnessName){
            case "Cáncer de piel":
                schoolHouseArrayList.add(new SchoolHouse("Escuela 1", "tab para la escuela 1"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 2", "tab para la escuela 2"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 3", "tab para la escuela 3"));
                break;
            case "Cáncer de mama":
                schoolHouseArrayList.add(new SchoolHouse("Escuela 1", "tab para la escuela 1"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 2", "tab para la escuela 2"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 3", "tab para la escuela 3"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 4", "tab para la escuela 4"));
                break;
            case "Cáncer de próstata":
                schoolHouseArrayList.add(new SchoolHouse("Escuela 1", "tab para la escuela 1"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 2", "tab para la escuela 2"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 3", "tab para la escuela 3"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 4", "tab para la escuela 4"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 5", "tab para la escuela 5"));
                break;
            default:
                schoolHouseArrayList.add(new SchoolHouse("Escuela 1", "tab para la escuela 1"));
                schoolHouseArrayList.add(new SchoolHouse("Escuela 2", "tab para la escuela 2"));
                break;


        }
        // link the Illness and the SchoolHouse together in the join table
        this.linkSchoolsAndIllnesses(schoolHouseArrayList, illness);
    }

    private void linkSchoolsAndIllnesses(ArrayList<SchoolHouse> schoolHouseArrayList, Illness illness) {
        Log.d("Insert: ", "Inserting some schools");

        try {
            final Dao<SchoolHouse, Integer> schoolsHouseDao = databaseHelper.getSchoolHouseDao();
            final Dao<IllnessSchoolHouse, Integer> illnessesSchoolHousesDao = databaseHelper.getIllnessesSchoolHousesDao();
            for(SchoolHouse schoolHouse: schoolHouseArrayList){
                schoolsHouseDao.create(schoolHouse);
                String log = "SchoolHouse " + schoolHouse.getSchoolName() + ", saved in database. " ;
                // Writing Illness to log
                Log.d("DatabasePopulatorUtil: ", log);
                IllnessSchoolHouse illnessSchoolHouse = new IllnessSchoolHouse(illness, schoolHouse);
                illnessesSchoolHousesDao.create(illnessSchoolHouse);
                log = "SchoolHouse " + schoolHouse.getSchoolName() + ", linked to Illness: " + illness.getIllnessName() ;
                // Writing Illness to log
                Log.d("DatabasePopulatorUtil: ", log);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
