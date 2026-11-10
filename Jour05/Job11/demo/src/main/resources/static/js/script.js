const bouton = document.getElementById("monBouton");
const elementMot = document.getElementById("prenom");

bouton.addEventListener("click", () => {
  if (elementMot.textContent === "Aicha") {
    elementMot.textContent = "Thierry";
  } else {
    elementMot.textContent = "Aicha";
  }
});
