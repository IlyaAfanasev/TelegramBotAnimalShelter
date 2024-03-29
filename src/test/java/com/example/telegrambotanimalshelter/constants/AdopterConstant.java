package com.example.telegrambotanimalshelter.constants;

import com.example.telegrambotanimalshelter.models.Adopter;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotanimalshelter.constants.AnimalConstant.*;
import static com.example.telegrambotanimalshelter.constants.SubscriberConstant.*;

public class AdopterConstant {
    public static final Adopter ADOPTER1 = new Adopter(1L,30, SUBSCRIBER1, ANIMAL_CAT1);
    public static final Adopter ADOPTER1_45TP = new Adopter(1L,45, SUBSCRIBER1, ANIMAL_CAT1);
    public static final Adopter ADOPTER2 = new Adopter(2L,30, SUBSCRIBER2, ANIMAL_CAT2);
    public static final Adopter ADOPTER2_45TP = new Adopter(2L,45, SUBSCRIBER2, ANIMAL_CAT2);
    public static final Adopter ADOPTER3 = new Adopter(3L, 30,SUBSCRIBER3, ANIMAL_DOG1);
    public static final Adopter ADOPTER4 = new Adopter(4L, 30,SUBSCRIBER4, ANIMAL_DOG2);

    public static final List<Adopter> SHELTER1_ADOPTERS = new ArrayList<>(List.of(ADOPTER1, ADOPTER2));
    public static final List<Adopter> SHELTER2_ADOPTERS = new ArrayList<>(List.of(ADOPTER3, ADOPTER4));


}
