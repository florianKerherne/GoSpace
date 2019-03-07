<template>
  <div class="connexion">
    <div id="app">
      <b-form @submit="onSubmit">
        <b-form-group id="exampleInputGroup1" label="Email adresse:" label-for="exampleInput1">
          <b-form-input
            id="exampleInput1"
            type="email"
            v-model="user.email"
            required
            placeholder="Enter email"
          ></b-form-input>
        </b-form-group>
        <b-form-group id="exampleInputGroup2" label="Password:" label-for="exampleInput2">
          <b-form-input
            id="exampleInput2"
            type="password"
            v-model="user.mdp"
            required
            placeholder="password"
          ></b-form-input>
        </b-form-group>
        <b-form-checkbox class="mb-2 mr-sm-2 mb-sm-0">Remember me</b-form-checkbox>
        <b-button variant="primary" type="submit">Connexion</b-button>
      </b-form>
    </div>
    <div>
      <div v-if="errors.length">
          <p v-for="error in errors" v-bind:key="error">{{ error }}</p>
      </div>
      <p>{{userId}}</p>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "connexion",

  data() {
    return {
      posts: [],
      errors: [],
      user: {
        email: "",
        nom: "",
        prenom: "",
        mdp: "",
        isAdmin: false,
        id: 0
      },
      userId: "",
      show: true
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callConnexion() {
      var params = {
        nom: this.user.nom,
        prenom: this.user.prenom,
        email: this.user.email,
        mdp: this.user.mdp,
        isAdmin: this.user.isAdmin
      };
      AXIOS.post(`/utilisateurExist`, params)
        .then(response => {
           console.log(response.data);
            this.utilisteurAuthentifier();
        })
        .catch(e => {
          this.errors.push("Addresse mail ou mot de passe invalide.");
          this.posts.push(e);
        });
    },
    onSubmit(evt) {
      this.errors = [];
      evt.preventDefault();
      this.callConnexion();
      //alert(JSON.stringify(this.user));
    },
    utilisteurAuthentifier() {
      localStorage.setItem('user', JSON.stringify(this.user));
      window.location = "http://localhost:8080/#/"
    },
    onReset(evt) {
      evt.preventDefault();
      /* Reset our form values */
      this.user.email = "";
      this.user.password = "";
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>
<style scoped>
#co {
  padding: 30px;
}
#app {
  padding: 30px;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;
  color: #eb0606;*/
}
</style>