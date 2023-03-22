package edu.bip.client.entity;

import java.util.List;

public class publisherEntity
{

    private Long publisher_id;

    private String publisher;

    private String city;


    @Override
    public String toString()
    {
        return publisher + " "+city.charAt(0);
    }
}
