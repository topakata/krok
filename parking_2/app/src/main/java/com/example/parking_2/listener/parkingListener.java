package com.example.parking_2.listener;

import com.example.parking_2.model.Parking;

import java.util.ArrayList;
import java.util.List;

public interface parkingListener {
    void addParking(Parking parking);
    void addOneParkingList(List<Parking> parkingList);
}
