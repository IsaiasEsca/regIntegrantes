package com.itsoeh.episaias.regintegrantes.Modelo;

public class MIntegrantesV2 {

private String  Integrante1,
                 Integrante2,
                 Integrante3,
                 Integrante4,
                 CorreInt1,
                 CorreInt2,
                 CorreInt3,
                 CorreInt4;
private String matricula;

    public MIntegrantesV2() {
    }

    public MIntegrantesV2(String integrante1, String integrante2, String integrante3, String integrante4, String correInt1, String correInt2, String correInt3, String correInt4, String matricula) {
        Integrante1 = integrante1;
        Integrante2 = integrante2;
        Integrante3 = integrante3;
        Integrante4 = integrante4;
        CorreInt1 = correInt1;
        CorreInt2 = correInt2;
        CorreInt3 = correInt3;
        CorreInt4 = correInt4;
        this.matricula = matricula;
    }

    public String getIntegrante1() {
        return Integrante1;
    }

    public void setIntegrante1(String integrante1) {
        Integrante1 = integrante1;
    }

    public String getIntegrante2() {
        return Integrante2;
    }

    public void setIntegrante2(String integrante2) {
        Integrante2 = integrante2;
    }

    public String getIntegrante3() {
        return Integrante3;
    }

    public void setIntegrante3(String integrante3) {
        Integrante3 = integrante3;
    }

    public String getIntegrante4() {
        return Integrante4;
    }

    public void setIntegrante4(String integrante4) {
        Integrante4 = integrante4;
    }

    public String getCorreInt1() {
        return CorreInt1;
    }

    public void setCorreInt1(String correInt1) {
        CorreInt1 = correInt1;
    }

    public String getCorreInt2() {
        return CorreInt2;
    }

    public void setCorreInt2(String correInt2) {
        CorreInt2 = correInt2;
    }

    public String getCorreInt3() {
        return CorreInt3;
    }

    public void setCorreInt3(String correInt3) {
        CorreInt3 = correInt3;
    }

    public String getCorreInt4() {
        return CorreInt4;
    }

    public void setCorreInt4(String correInt4) {
        CorreInt4 = correInt4;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "MIntegrantesV2{" +
                "Integrante1='" + Integrante1 + '\'' +
                ", Integrante2='" + Integrante2 + '\'' +
                ", Integrante3='" + Integrante3 + '\'' +
                ", Integrante4='" + Integrante4 + '\'' +
                ", CorreInt1='" + CorreInt1 + '\'' +
                ", CorreInt2='" + CorreInt2 + '\'' +
                ", CorreInt3='" + CorreInt3 + '\'' +
                ", CorreInt4='" + CorreInt4 + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
