/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedago
 */
public class ClientEntity {
    private String code;
    private String societe;
    private String contact;
    private String fonction;
    private String adresse;
    private String ville;
    private String region;
    private String code_postal;
    private String pays;
    private String telephone;
    private String fax;
    
    public ClientEntity(String c, String s, String co, String f ,String a, String v,String r ,String cp, String p, String t ,String fax){
        this.code = c;
        this.societe = s;
        this.contact = co;
        this.fonction = f;
        this.adresse = a;
        this.ville = v;
        this.region=r;
        this.code_postal=cp;
        this.pays=p;
        this.telephone=t;
        this.fax=fax;
        
    }
    
    @Override
    public String toString(){
        String res = "Code : " + this.code + " | ";
        res += "Société : " + this.societe + " | ";
        res += "Contact : " + this.contact + " | ";
        res += "Fonction : " + this.fonction + " | ";
        res += "Adresse : " + this.adresse + " | ";
        res += "Ville : " + this.ville + " | ";
        if(this.region != null){
            res += "Région : " + this.region + " | ";
        }
        res += "CP: " + this.code_postal + " | ";
        res += "Pays : " + this.pays + " | ";
        res += "Tel : " + this.telephone + " | ";
        res += "Fax : " + this.fax + " | ";
        return res;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
}
