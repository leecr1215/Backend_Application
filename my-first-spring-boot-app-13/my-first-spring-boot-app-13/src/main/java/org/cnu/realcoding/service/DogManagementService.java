package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exection.DogNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogManagementService {

    @Getter
    private List<Dog> dogs = new ArrayList<>();

    public void insertDog(Dog dog) {
        dogs.add(dog);
    }

    public Dog getDogByName(String name) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }
<<<<<<< Updated upstream
    public Dog DogByOwnerName(String ownerName){
=======

    public Dog getDogByOwnerName(String ownerName){
        dogs = dogRepository.findDogByOwnerName(ownerName);
>>>>>>> Stashed changes
        for (Dog dog : dogs) {
            if (dog.getOwnerName().equals(ownerName)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

<<<<<<< Updated upstream
    public Dog DogByPhoneNumber(String phoneNum){
        for (Dog dog : dogs) {
            if (dog.getOwnerPhoneNumber().equals(phoneNum)) {
=======
    public Dog getDogByPhoneNumber(String ownerPhoneNumber){
        dogs = dogRepository.findDogByPhoneNumber(ownerPhoneNumber);
        for (Dog dog : dogs) {
            if (dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
>>>>>>> Stashed changes
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

<<<<<<< Updated upstream
    public Dog DogByAll(String dogName, String ownerName, String phoneNum){
        for (Dog dog : dogs) {
            if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(phoneNum)) {
=======
    public Dog getDogByAll(String dogName, String ownerName, String ownerPhoneNumber){
        dogs = dogRepository.findDogByAll(dogName,ownerName,ownerPhoneNumber);

        for (Dog dog : dogs) {
            if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
>>>>>>> Stashed changes
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

<<<<<<< Updated upstream
    public void UpdateAllInfo(String dogName, String ownerName, String phoneNum, String newDogName, String newDogKind,String newOwnerName, String newPhoneNum){
        for (Dog dog : dogs) {
            if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(phoneNum)) {
                dog.setName(newDogName);
                dog.setKind(newDogKind);
                dog.setOwnerName(newOwnerName);
                dog.setOwnerPhoneNumber(newPhoneNum);
            }
        }
        throw new DogNotFoundException();
    }

    public void UpdateKind(String dogName, String ownerName, String phoneNum, String newDogKind){
        for (Dog dog : dogs) {
            if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(phoneNum)) {
                dog.setKind(newDogKind);
            }
        }
        throw new DogNotFoundException();
    }

    public void UpdateMedicalRecord(String dogName, String ownerName, String phoneNum, String medicalRecord){
        for (Dog dog : dogs) {
            if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(phoneNum)) {
                dog.getMedidcalRecords().add(medicalRecord);
            }
=======
    public void UpdateAllInfo(String dogName, String ownerName, String ownerPhoneNumber, String newDogName, String newDogKind,String newOwnerName, String newPhoneNum){
        dogs = dogRepository.findAllDog();
        try {
            for (Dog dog : dogs) {
                if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                    dog.setName(newDogName);
                    dog.setKind(newDogKind);
                    dog.setOwnerName(newOwnerName);
                    dog.setOwnerPhoneNumber(newPhoneNum);
                    dogRepository.updateAll(dogName, ownerName, ownerPhoneNumber, newDogName, newDogKind, newOwnerName, newPhoneNum);
                }
            }
        } catch(DogNotFoundException e) {

        } finally {
            dogs = dogRepository.findAllDog();
        }
    }

    public void UpdateKind(String dogName, String ownerName, String ownerPhoneNumber, String newDogKind){
        dogs = dogRepository.findAllDog();
        try{
            for (Dog dog : dogs) {
                if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                    dog.setKind(newDogKind);
                    dogRepository.updateKind(dogName,newDogKind,ownerName,ownerPhoneNumber);
                }
            }
        }catch (DogNotFoundException e){

        } finally {
            dogs = dogRepository.findAllDog();
        }

    }

    public void InsertMedicalRecord(String name, String ownerName, String ownerPhoneNumber, String newMedicalRecord){
        dogs = dogRepository.findAllDog();
        try {
            for (Dog dog : dogs) {
                if (dog.getName().equals(name) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(ownerPhoneNumber)){
                    dogRepository.insertMedicalRecords(name, ownerName, ownerPhoneNumber, newMedicalRecord);
                }
            }
        } catch (DogNotFoundException e) {

        } finally {
            dogs = dogRepository.findAllDog();
>>>>>>> Stashed changes
        }
    }
}
