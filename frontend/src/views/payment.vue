<template>
  <div class="About">
    <div class="row">
      <div class="col-md-4"></div>
      <div class="col-md-4">
        <b-form
          accept-charset="UTF-8"
          class="require-validation"
          id="payment-form"
          @submit="onSubmit"
        >
          <b-form-group
            id="gTitulaire"
            label="Titulaire de la carte"
          >
            <b-form-input
              id="titulaire"
              type="text"
              v-model="card.titulaire"
              required
              placeholder="Entrer le titulaire"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="gNumero"
            label="Numéro de la carte"
          >
            <b-form-input
              id="Numero"
              type="number"
              v-model="card.numero"
              required
              placeholder="Entrer le numéro"
            ></b-form-input>
          </b-form-group>
          
          <b-form-group
            id="gCvc"
            label="CVC"
          >
            <b-form-input
              id="Cvc"
              type="number"
              v-model="card.cvc"
              required
              placeholder="ex. 311"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="gExp"
            label="Expiration"
          >
            <b-form-input
              id="MoisExp"
              type="number"
              v-model="card.moisExp"
              required
              placeholder="MM"
            ></b-form-input>
            
            <b-form-input
              id="AnneeExp"
              type="number"
              v-model="card.anneeExp"
              required
              placeholder="AAAA"
              size="4"
            ></b-form-input>
          </b-form-group>

          <div class="form-control total btn btn-info">
            Total:
            <span class="amount">{{prixFinal}} €</span>
             
          </div>
            <b-btn class="form-control total btn btn-info" type="submit" >Finaliser la transaction</b-btn>
        </b-form>
      </div>
      <div class="col-md-4"></div>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "about",

  data() {
    return {
      card: {
        titulaire: "",
        numero: "",
        moisExp: "",
        anneeExp: "",
        cvc: ""
      },
      posts: [],
      errors: [],
      userId: "123",
      prixFinal:0,
      result:""
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callRestService() {
      AXIOS.get(`about`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.posts = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    action(){
      console.log("transaction");
      this.redirection();
    },
    onSubmit(evt) {
      /*var params = {
        nom: "",
        prenom: "",
        email:"",
        mdp: "",
        isAdmin: ""
      };
      */AXIOS.post(`/Payment`)
        .then(response => {
           //console.log(response.data);
            //this.utilisteurAuthentifier();
        })
        .catch(e => {
          this.errors.push("error post.");
          this.posts.push(e);
        });
      this.redirection();
      
    },
    redirection() {
      //this.$router.push({ path: `/Connexion/${this.userId}` });
      this.$router.push({ path: `/PaymentValider/`, query: { } });
    },
    chargePrixVoyage(idVoyage) {
      AXIOS.get(`voyage/` + idVoyage)
        .then(response => {
          // JSON responses are automatically parsed.
            this.prixFinal = response.data.prix ;
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    getTotalPanier() {
      var tailleTableau = this.posts.length;
      this.prixFinal = 0;
      var i;
      for (i = 0; i < tailleTableau; i++) {
        this.posts.pop();
      }
      var prixToTalTemp = 0;
      this.result.forEach(function(element) {
        //if(element.id_voyage.prix)
        prixToTalTemp += element.id_voyage.prix;
      });
      this.prixFinal = prixToTalTemp;
    },
    chargePrixPanier(){
      AXIOS.get(`panier/` + 1)
      .then(response => {
        this.result = response.data;
        this.getTotalPanier();
      })
      .catch(e => {
        this.errors.push(e);
      });
    }
  },
  mounted: function() {
    if(this.$route.query.id>0){
      this.chargePrixVoyage(this.$route.query.id);
    }else{
      this.chargePrixPanier();
    }
    
  }
};
</script>
