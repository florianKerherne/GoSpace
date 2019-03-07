import Vue from "vue";
import Router from "vue-router";
import PaymentValider from "./views/PaymentValider.vue";
import Connexion from "./views/Connexion.vue";
import Inscription from "./views/Inscription.vue";
import Voyage from "./views/Voyage.vue";
import ListVoyage from "./views/ListVoyage.vue";
import Panier from "./views/Panier.vue";
import Acceuil from "./views/Acceuil.vue";

Vue.use(Router);

export default new Router({
  mode: "hash",
  base: process.env.BASE_URL,
  routes: [{
      path: "/PaymentValider",
      name: "PaymentValider",
      component: PaymentValider
    },
    {
      path: "/payment",
      name: "payment",
      component: () =>
        import( /* webpackChunkName: "payment" */ "./views/payment.vue"),
      props: true
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
      path: "/voyage",
      name: "voyage",
      component: Voyage,
      props: true
    },
    {
      path: "/listVoyage",
      name: "listVoyage",
      component: ListVoyage,
      props: true
    },
    {
      path: "/panier",
      name: "panier",
      component: Panier,
      props: true
    },
    {
      path: "/",
      name: "Acceuil",
      component: Acceuil,
      props: true
    }
  ]
});