package br.com.fiap.entities;

public class CompanyClient {
    private int companyId;
    private String name;
    private String cnpj;
    private String segment;

    public CompanyClient() {
    }

    public CompanyClient(String name, String cnpj, String segment) {
        this.name = name;
        this.cnpj = cnpj;
        this.segment = segment;
    }

    public CompanyClient(int companyId, String name, String cnpj, String segment) {
        this.companyId = companyId;
        this.name = name;
        this.cnpj = cnpj;
        this.segment = segment;
    }

    public boolean validateName() {
        return name != null && !name.isBlank();
    }

    public boolean validateCnpj() {
        return cnpj != null && !cnpj.isBlank();
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }
}
