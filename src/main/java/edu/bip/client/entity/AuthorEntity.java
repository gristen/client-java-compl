package edu.bip.client.entity;

import lombok.Data;

import java.util.List;


@Data

public class AuthorEntity
{

    private  Long id;

    private String name;

    private String lastname;
    private String surname;

    @Override
    public String toString()
    {
        return name + " "+lastname.charAt(0)+ "."+surname.charAt(0)+".";
    }
}

