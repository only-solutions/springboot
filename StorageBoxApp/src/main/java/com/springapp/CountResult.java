package com.springapp;

//class used by JPQL in StorageBoxRepository @Query to store results of the query
//JPQSL can be read as a constructor for this class "new CountResult(SQL here...)
public class CountResult {
    private Integer countval;

    public CountResult()
    {
        countval=-1;
    }
    public CountResult(Integer setval)
    {
        if (setval == null)
            countval = null;
        else
            countval= setval;
    }
    public CountResult(Long setval)
    {
        if (setval == null)
            countval = 10;
        else
            countval=setval.intValue();
    }

    public Integer getCountval() {
        return countval;
    }
    public void setCountval(int countval) {
        this.countval = countval;
    }
}
