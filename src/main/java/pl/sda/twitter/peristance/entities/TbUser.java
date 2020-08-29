package pl.sda.twitter.peristance.entities;

import lombok.Builder;

@Builder
public class TbUser {
    private int id;
    private String login;
    private String password;
}
