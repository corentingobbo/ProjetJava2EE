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
public class CommandeEntity {
    
    private int numero;
    private String client;
    private String saisie_le;
    private String envoye_le;
    private int port;
    private String destinataire;
    private String adresse_livraison;
    private String ville_livraison;
    private String region_livraison;
    private String code_postal_livraison;
    private String pays_livraison;
    private float remise;
    
    public CommandeEntity(int n,String c,String s,String e, int p, String d,String al,String vl,String rl,String cpl,String pl,float r ){
        this.numero = n;
        this.client=c
        this.saisie_le=s;
        this.envoye_le=e;
        this.port=p;
        this.destinataire=d;
        this.adresse_livraison=al;
        this.ville_livraison=vl;
        this.region_livraison = rl;
        this.code_postal_livraison = cpl;
        this.pays_livraison=pl;
        this.remise=r;
        
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSaisie_le() {
        return saisie_le;
    }

    public void setSaisie_le(String saisie_le) {
        this.saisie_le = saisie_le;
    }

    public String getEnvoye_le() {
        return envoye_le;
    }

    public void setEnvoye_le(String envoye_le) {
        this.envoye_le = envoye_le;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public String getVille_livraison() {
        return ville_livraison;
    }

    public void setVille_livraison(String ville_livraison) {
        this.ville_livraison = ville_livraison;
    }

    public String getRegion_livraison() {
        return region_livraison;
    }

    public void setRegion_livraison(String region_livraison) {
        this.region_livraison = region_livraison;
    }

    public String getCode_postal_livraison() {
        return code_postal_livraison;
    }

    public void setCode_postal_livraison(String code_postal_livraison) {
        this.code_postal_livraison = code_postal_livraison;
    }

    public String getPays_livraison() {
        return pays_livraison;
    }

    public void setPays_livraison(String pays_livraison) {
        this.pays_livraison = pays_livraison;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }
    
            
}
