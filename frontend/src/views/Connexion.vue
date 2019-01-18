<template>


  <div class="connexion">
    <div id="app">
      <b-form @submit="onSubmit">
        <b-form-group id="exampleInputGroup1"
                      label="Email adresse:"
                      label-for="exampleInput1">
          <b-form-input id="exampleInput1"
                        type="email"
                        v-model="user.email"
                        required
                        placeholder="Enter email">
          </b-form-input>
        </b-form-group>
        <b-form-group id="exampleInputGroup2"
                      label="Password:"
                      label-for="exampleInput2">
          <b-form-input id="exampleInput2"
                        type="password"
                        v-model="user.name"
                        required
                        placeholder="password">
          </b-form-input>
        </b-form-group>
        <b-form-checkbox class="mb-2 mr-sm-2 mb-sm-0">Remember me</b-form-checkbox>
        <b-button variant="primary" type="submit" >Connexion</b-button>
      </b-form>
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
        email: '',
        password: ''
      },
      show: true
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callConnexion() {
      AXIOS.get(`/connexion/{email}/{mdp}`)
        .then(response => {
          alert(response.data);
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    onSubmit (evt) {
      evt.preventDefault();
      this.callConnexion();
      alert(JSON.stringify(this.user));
    },
    onReset (evt) {
      evt.preventDefault();
      /* Reset our form values */
      this.user.email = '';
      this.user.password = '';
      this.show = false;
      this.$nextTick(() => { this.show = true });
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
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #eb0606;
}
</style>