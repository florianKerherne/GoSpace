import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";
import Connexion from "./views/Connexion.vue";
import Inscription from "./views/Inscription.vue";
import Voyage from "./views/Voyage.vue";
import ListVoyage from "./views/ListVoyage.vue";

Vue.use(Router);

export default new Router({
  mode: "hash",
  base: process.env.BASE_URL,
  routes: [{
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import( /* webpackChunkName: "about" */ "./views/About.vue")
    },
    {
      path: "/connexion",
      name: "connexion",
      component: Connexion
    },
    {
      path: "/inscription",
      name: "inscription",
      component: Inscription
    },
    {
      path: "/voyage/:id",
      name: "voyage",
      component: Voyage
    },
    {
      path: "/listVoyage",
      name: "listVoyage",
      component: ListVoyage
    }
  ]
});