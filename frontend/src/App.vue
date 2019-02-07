<template>
  <div id="app">
    <b-navbar toggleable="md" type="dark" class="navbar navbar-default navbar-fixed-top">
      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
      <b-collapse is-nav id="nav_collapse" class="pull-right">
        <b-navbar-nav>
          <ul class="nav navbar-nav">
            <b-nav-item to="/">Bonjour</b-nav-item>
            <b-nav-item to="/about">About</b-nav-item>
            <b-nav-item to="/listVoyage">Liste des voyages</b-nav-item>
            <b-nav-item to="/connexion">Connexion</b-nav-item>
            <b-nav-item to="/inscription">Inscription</b-nav-item>
          </ul>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
a {
  color: #ffffff;
}
.navbar-default {
  background-color: #0080ff;
  border-color: #118bee;
}
.navbar-fixed-top {
  top: 0;
  border-width: 0 0 1px;
}
.navbar-fixed-top,
.navbar-fixed-bottom {
  position: relative;
  right: 0;
  left: 0;
  z-index: 1030;
}
.navbar-header {
  float: left;
}
.navbar-nav {
  float: left;
  margin: 0;
}
.navbar-nav > li {
  float: left;
}
.navbar {
  min-height: 50px;
  margin-bottom: 17pt;
  border: 1px solid transparent;
}
.navbar-toggle {
  position: relative;
  float: right;
  margin-right: 15px;
  padding: 9px 10px;
  margin-top: 8px;
  margin-bottom: 8px;
  background-color: transparent;
  background-image: none;
  border: 1px solid transparent;
  border-radius: 4px;
}
.navbar-nav > li > a {
  padding-top: 10px;
  padding-bottom: 10px;
  line-height: 27px;
  font-size: 13pt;
  text-transform: uppercase;
}
.navbar-nav > li {
  float: left;
}
.nav > li > a {
  position: relative;
  display: block;
  padding: 10px 15px;
}
a.navbar-brand {
  width: 60px;
  height: 60px;
  margin-right: 10px;
}
.logo {
  display: inline-block;
  width: 60px;
  height: 60px;
  margin-right: 10px;
  overflow: hidden;
}
li {
  display: list-item;
  text-align: -webkit-match-parent;
}
div {
  display: block;
}
.container {
  margin-right: auto;
  margin-left: auto;
  padding-left: 15px;
  padding-right: 15px;
}
</style>
