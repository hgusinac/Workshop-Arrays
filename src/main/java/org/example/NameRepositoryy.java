package org.example;

import java.util.Arrays;

public class NameRepositoryy {
    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    }

    public static void setName(String[] names) {
        NameRepositoryy.names = names;
    }

    public static void clear() {
        names = new String[0];
    }

    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }

    public static String find(final String fullName) {

        for (String s : names) {
            if (s.equalsIgnoreCase(fullName)) {
                return s;
            }
        }
        return null;

    }

    public static boolean add(final String fullName) {

        if (find(fullName) != null) {
            return false;
        }
        String[] temp = Arrays.copyOf(names, names.length + 1);
        temp[temp.length - 1] = fullName;
        names = temp;
        return true;
    }

    public static String[] findByFirstName(final String firstName) {
        // Create empty array
        String[] result = {};

        // iterate though names
        for (String fullname : names) {
            //Extracting each first name
            String fName = fullname.substring(0, fullname.indexOf(" "));
            // Check if firstname equals ignoring cast fName
            if (fName.equalsIgnoreCase(firstName)) {
                //call private method that handle adding to array
                result = addToArray(result, fullname);
            }
        }
        return result;
    }


    public static String [] findByLastName(final String lastName) {
        // Create empty array
        String [] result = {};

        // iterate though names
        for (String fullname :names){
            //Extracting each last name
            String lName= fullname.substring(fullname.indexOf(" ") +1);
            // Check if firstname equals ignoring cast lName
            if (lName.equalsIgnoreCase(lastName)){
                //call private method that handle adding to array
                result = addToArray(result,fullname);
            }
        }
        return result;
    }
    private static int indexOf(String[] array, String string){
        int invalidIndex = -1;
        for (int i =0;i< array.length;i++){
            String content =array[i];
            if (content.equalsIgnoreCase(string)){
                return i;
            }
        }

        return invalidIndex;
    }

    public static boolean update(final String original,final String updatedName){
        int originalIndex = indexOf(names,original);
        if (originalIndex == -1){
            return false;
        }
        int updatedIndex = indexOf(names,updatedName);
        if (updatedIndex != -1){
            return false;
        }
        names[originalIndex] = updatedName;
        return true;

    }



    private static String[] addToArray(String[] source, String string) {
        String [] temp = Arrays.copyOf(source,source.length +1);
        temp[temp.length -1] = string;
        return temp;
    }
    public static boolean remove (final String fullName){
        String [] newNames = new String[0];
        for (String name:names){
            if (!name.equalsIgnoreCase(fullName)) {
                newNames =Arrays.copyOf(newNames,newNames.length +1);
                newNames[newNames.length -1] =name;
            }

        }
        if (names.length != newNames.length){
            names=newNames;
            return true;
        }
        return false;
    }
}
