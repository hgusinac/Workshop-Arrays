package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {

        String [] data ={"Erik Svensson","Haris Gusinac","Erik gusinac","pelle svensson"};

        NameRepositoryy.setName(data);

        String[] eriks = NameRepositoryy.findByFirstName("erik");
        System.out.println(Arrays.toString(eriks));
        String [] svenssons = NameRepositoryy.findByLastName("svensson");
        System.out.println(Arrays.toString(svenssons));

        System.out.println(NameRepositoryy.update("pelle Svensson" ,"Ola Svennson"));
        System.out.println(Arrays.toString(NameRepositoryy.findAll()));
        System.out.println(NameRepositoryy.remove("Haris Gusinac"));
        System.out.println(Arrays.toString(NameRepositoryy.findAll()));

    }
}
