package com.springapp;

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
