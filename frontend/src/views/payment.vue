<template>
  <div class="About">
    <div class='row'>
        <div class='col-md-4'></div>
        <div class='col-md-4'>
          
          <b-form accept-charset="UTF-8" action="/" class="require-validation" data-cc-on-file="false"
           data-stripe-publishable-key="pk_bQQaTxnaZlzv4FnnuZ28LFHccVSaj" id="payment-form" method="post">
            <b-form-group id="exampleInputGroup1" label="Titulaire de la carte" label-for="exampleInput1">
              <b-form-input
                id="exampleInput1"
                type="text"
                v-model="card.titulaire"
                required
                placeholder="Entrer le titulaire"
              ></b-form-input>
            </b-form-group>
            <b-form-group id="exampleInputGroup1" label="Numéro de la carte" label-for="exampleInput1">
              <b-form-input
                id="exampleInput1"
                type="number"
                v-model="card.numero"
                required
                placeholder="Entrer le numéro"
              ></b-form-input>
            </b-form-group>
            <div class='form-row'>
              <div class='col-xs-12 form-group card required'>
                <label class='control-label'>Card Number</label>
                <input autocomplete='off' class='form-control card-number' size='20' type='text'>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-xs-4 form-group cvc required'>
                <label class='control-label'>CVC</label>
                <input autocomplete='off' class='form-control card-cvc' placeholder='ex. 311' size='4' type='text'>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'>Expiration</label>
                <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text'>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'> </label>
                <input class='form-control card-expiry-year' placeholder='YYYY' size='4' type='text'>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12'>
                <div class='form-control total btn btn-info'>
                  Total:
                  <span class='amount'>$300</span>
                </div>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12 form-group'>
                <button class='form-control btn btn-primary submit-button' type='submit'>Pay »</button>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12 error form-group hide'>
                <div class='alert-danger alert'>
                  Please correct the errors and try again.
                </div>
              </div>
            </div>
          </b-form>
        </div>
        <div class='col-md-4'></div>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "about",

  data() {
    return {
      card : {
        titulaire: "",
        numero: "",
        moisExp: "",
        anneeExp: "",
        cvc: "" 
      },
      posts: [],
      errors: [],
      userId: "123"
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

    test() {
      //this.$router.push({ path: `/Connexion/${this.userId}` });
      this.$router.push({ path: `/Connexion/`, query: { id: this.userId } });
    }
  }
};
</script>
