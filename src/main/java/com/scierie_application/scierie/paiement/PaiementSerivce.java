package com.scierie_application.scierie.paiement;


import com.scierie_application.scierie.client.RepositoryClient;
import com.scierie_application.scierie.contrat.Contrat;
import com.scierie_application.scierie.contrat.ContratRepository;
import com.scierie_application.scierie.handler.exeption.ClientNotFoundException;
import com.scierie_application.scierie.handler.exeption.ContratNotFoundException;
import com.scierie_application.scierie.handler.exeption.TarifNotFoundException;
import com.scierie_application.scierie.handler.exeption.TypePaiementNotFoundException;
import com.scierie_application.scierie.tarif.TarifRepository;
import com.scierie_application.scierie.type_paiement.TypePaiement;
import com.scierie_application.scierie.type_paiement.Type_paiementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaiementSerivce {
    @Autowired
    private PaiementRepository pr ;
    @Autowired
    private ContratRepository cr ;
    @Autowired
    private RepositoryClient clr ;
    @Autowired
    private TarifRepository tr ;



    @Autowired
    private Type_paiementRepository tp ;

    public String makePaiement(PaiementDTO1 p){
        ///recuperation du contrat
        var c = this.cr.findByCode(p.getContrat()).orElseThrow(()->new ContratNotFoundException("contrat not found"));
        var client = this.clr.findById(p.getId_client()).orElseThrow(()->new ClientNotFoundException("contrat not found"));
        var t = this.tr.findByCode(p.getTarif()).orElseThrow(()-> new TarifNotFoundException("Tarif not found"));
        var type =  this.tp.findByLibelle(p.getType_paiement()).orElseThrow(()-> new TypePaiementNotFoundException("type not found"));



        if(p.getId_paiement() != null){
            if(this.pr.existsById(p.getId_paiement())){
                    return "Payement invalid";
            }
            var paiement = this.pr.findById(p.getId_paiement());
            paiement.get().setEtat_paiement(setEtatPaiement(type , paiement.get()));
            this.pr.save(paiement.get());
            return "payement done";

        }

        this.pr.save(Paiement.builder()
                .client(client)
                .date_cloture(p.getDate_cloture())
                 .etat_paiement(this.initEtatPaiement(type.getNbrTranche()))
                .tarif(t)
                .type_paiement(type)
            .build());


        return "payement done" ;
    }



    public String setEtatPaiement(TypePaiement t , Paiement p){
            switch (t.getNbrTranche()){
                case  1 : {
                    return p.getEtat_paiement().equals("0")? "1" : "1";

                }
                case  2 : {
                    return p.getEtat_paiement().equals("0-0")? "0-1" : "1-1";
                }
                case  3 : {
                    if(p.getEtat_paiement().equals("0-0-0")){
                        return "0-0-1";
                    }else{
                        return p.getEtat_paiement().equals("0-0-1")? "0-1-1" : "1-1-1";
                    }
                }
                default : {
                    return "*";
                }
            }

    }
    public String initEtatPaiement(int nbrTranche){
            if(nbrTranche == 1) return "0";
            return nbrTranche == 2 ? "0-0" :nbrTranche == 3? "0-0-0" : null;
    }


    public String response(){
        return "";
    }


    public boolean delete(String code){
        var p =  this.pr.findByCode(code).orElseThrow(()-> new RuntimeException("paiement not found"));
        this.pr.deleteById(p.getId_paiement());
        return true ;
    }




}
