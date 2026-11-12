const bouton = document.getElementById("refreshComments");
const container = document.getElementById("commentsContainer");

bouton.addEventListener("click", actualiserCommentaires);

async function actualiserCommentaires() {
    try {
        const response = await fetch("/comments-refresh");

        if (!response.ok) {
            throw new Error("Erreur lors du chargement des commentaires");
        }

        const html = await response.text();
        container.innerHTML = html;

    } catch (error) {
        console.error(error);
    }
}

document.addEventListener("DOMContentLoaded", actualiserCommentaires);