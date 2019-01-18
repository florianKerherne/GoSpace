<template>
  <div class="inscription">
    <div id="app">
      <b-form>
        <b-form-group id="InputEmailGroup" label="Email address:" label-for="InputEmail">
          <b-form-input
            id="InputEmail"
            type="email"
            v-model="user.email"
            required
            placeholder="Enter email"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="InputLastNameGroup" label="Last name:" label-for="InputLastName">
          <b-form-input
            id="InputLastName"
            type="text"
            v-model="user.nom"
            required
            placeholder="Enter last name"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="InputFirstNameGroup" label="First name:" label-for="InputName">
          <b-form-input
            id="InputFirstName"
            type="text"
            v-model="user.prenom"
            required
            placeholder="Enter first name"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="InputPasswordGroup" label="Password:" label-for="InputPassword">
          <b-form-input
            id="InputPassword"
            type="password"
            v-model="user.mdp"
            required
            placeholder="password"
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="InputPasswordConfirmGroup"
          label="Password confirm:"
          label-for="InputPasswordConfirm"
        >
          <b-form-input id="InputPasswordConfirm" type="password" required placeholder="password"></b-form-input>
        </b-form-group>

        <b-form-checkbox class="mb-2 mr-sm-2 mb-sm-0">J'accepte les condition d'utilisation</b-form-checkbox>
        <b-button variant="primary" @click="createUser()">Inscription</b-button>
      </b-form>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "inscription",

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
      show: true
    };
  },
  methods: {
    createUser() {
      var params = {
        nom: this.user.nom,
        prenom: this.user.prenom,
        email: this.user.email,
        mdp: this.user.mdp,
        isAdmin: this.isAdmin
      };

      AXIOS.post(`/utilisateur`, params)
        .then(response => {
          this.response = response.data;
          this.user.id = response.data;
          console.log(response.data);
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    callInscription() {
      AXIOS.get(`utilisateur/toto`)
        .then(response => {
          // JSON responses are automatically parsed.
          console.log(response.data);
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(evt) {
      evt.preventDefault();
      /* Reset our form values */
      this.form.email = "";
      this.form.password = "";
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
  color: #eb0606;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;
  color: #eb0606;*/
}
</style>
