<template>
  <div class="About">
    <div class="row">
      <div class="col-md-4"></div>
      <div class="col-md-4">
        <b-form
          accept-charset="UTF-8"
          action="/"
          class="require-validation"
          data-cc-on-file="false"
          data-stripe-publishable-key="pk_bQQaTxnaZlzv4FnnuZ28LFHccVSaj"
          id="payment-form"
          method="post"
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
            <b-btn class="form-control total btn btn-info" @click="action()" >Finaliser la transaction</b-btn>
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
      prixFinal:0
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
    redirection() {
      //this.$router.push({ path: `/Connexion/${this.userId}` });
      this.$router.push({ path: `/PaymentValider/`, query: { } });
    },
    chargePrixVoyage(idVoyage) {
      AXIOS.get(`voyage/` + idVoyage)
        .then(response => {
          // JSON responses are automatically parsed.
          if (response.data.promotion > 0) {
            this.prixFinal =
              response.data.prix -
              (response.data.prix * response.data.promotion) / 100;
          } else {
            this.prixFinal = response.data.prix;
          }
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  },
  mounted: function() {
    if(this.$route.query.id>0){
      this.chargePrixVoyage(this.$route.query.id);
    }
    
  }
};
</script>
