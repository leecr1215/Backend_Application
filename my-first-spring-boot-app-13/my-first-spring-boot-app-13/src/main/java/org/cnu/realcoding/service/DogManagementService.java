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
    public Dog DogByOwnerName(String ownerName){
        for (Dog dog : dogs) {
            if (dog.getOwnerName().equals(ownerName)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

    public Dog DogByPhoneNumber(String phoneNum){
        for (Dog dog : dogs) {
            if (dog.getOwnerPhoneNumber().equals(phoneNum)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

    public Dog DogByAll(String dogName, String ownerName, String phoneNum){
        for (Dog dog : dogs) {
            if (dog.getName().equals(dogName) && dog.getOwnerName().equals(ownerName) && dog.getOwnerPhoneNumber().equals(phoneNum)) {
                return dog;
            }
        }
        throw new DogNotFoundException();
    }

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
        }
    }
}
