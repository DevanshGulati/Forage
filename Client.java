package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client
{

    @Id
    @GeneratedValue()
    private long clientId;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    protected Client()
    {

    }

    public Client(Advisor advisor, String firstName, String lastName, String email)
    {
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getClientId()
    {
        return clientId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }


    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Advisor getAdvisor()
    {
        return advisor;
    }

    public void setAdvisor(Advisor advisor)
    {
        this.advisor = advisor;
    }

    public List<Portfolio> getPortfolios()
    {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios)
    {
        this.portfolios = portfolios;
    }
}
