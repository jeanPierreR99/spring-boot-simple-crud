package com.jeanpierre.javapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jeanpierre.javapi.model.Employe;

public class EmployeService {
    List<Employe> employeList = new ArrayList<Employe>();
    int ctx = 0;

    public void addEmploye(String name, String lastname, String role, int age, String salary) {
        this.ctx++;
        employeList.add(new Employe(ctx, name, lastname, role, age, salary));
    }

    public List<Employe> getAllEmployes() {
        return employeList;
    }

    public List<Employe> getEmployeById(int id) {
        List<Employe> matchingEmploye = new ArrayList<>();
        if (employeList != null) {
            for (Employe employe : employeList) {
                if (employe != null && employe.getId() == id) {
                    matchingEmploye.add(employe);
                }
            }
        }
        return matchingEmploye.isEmpty() ? null : matchingEmploye;
    }

    public void deleteById(int id) {
        for (Iterator<Employe> iterator = employeList.iterator(); iterator.hasNext();) {
            Employe employe = iterator.next();
            if (employe.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

}
