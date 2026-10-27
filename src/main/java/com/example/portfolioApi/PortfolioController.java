package com.example.portfolioApi;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    public record Profile(String name, String title, String about, String email,
                          String linkedin, String github, String location) {}

    public record Education(String degree, String school, String period, String description) {}

    public record Experience(String role, String company, String period,
                             List<String> missions, List<String> tech) {}

    public record Project(String title, String description, List<String> tech,
                          String github, String demo) {}

    public record SkillGroup(String category, List<String> skills) {}

    @GetMapping("/profile")
    public Profile profile() {
        return new Profile(
            "Ahmad Ouhammou",
            "Ingénieur Logiciel Full Stack Java (Spring Boot / React.js)",
            "Ingénieur logiciel junior full stack, spécialisé en développement Java / Spring Boot "
          + "(backend) et React.js (frontend). J’ai travaillé sur des architectures microservices "
          + "et sur l’intégration d’APIs d’intelligence artificielle. Je porte une attention "
          + "particulière à la sécurité applicative (JWT, OAuth2, bonnes pratiques OWASP) et aux "
          + "exigences de conformité RGPD dans la gestion des données. À l’aise avec la "
          + "conteneurisation Docker et la documentation d’APIs avec OpenAPI / Swagger.",
            "ahmadouhammou13@gmail.com",
            null, // ajoutez ici l'adresse de votre profil LinkedIn si vous le souhaitez
            "https://github.com/AhmedOuhammou",
            "Rabat, Maroc"
        );
    }

    @GetMapping("/education")
    public List<Education> education() {
        return List.of(
            new Education(
                "Master en Ingénierie Logicielle et Systèmes d’Information",
                "Faculté des Sciences et Techniques d’Errachidia",
                "2023 – 2025",
                "Projet de fin d’études réalisé chez FOS-MEF, Rabat (février – juillet 2025)."),
            new Education(
                "Licence en Informatique",
                "Faculté des Sciences et Techniques de Fès",
                "2020 – 2023",
                ""),
            new Education(
                "Baccalauréat Scientifique, option Mathématiques B",
                "Lycée Technique Errachidia",
                "2019 – 2020",
                "")
        );
    }

    @GetMapping("/experiences")
    public List<Experience> experiences() {
        return List.of(
            new Experience(
                "Stage de fin d’études (Master)",
                "FOS-MEF, Rabat",
                "Février – Juillet 2025 (5 mois)",
                List.of(
                    "Architecturé une application web distribuée en 4 microservices avec Spring Boot et Spring Cloud, réduisant le couplage entre modules.",
                    "Intégré des services d’IA via des APIs REST, automatisant 2 workflows métier auparavant manuels, en orchestrant les endpoints depuis le backend Spring Boot.",
                    "Développé une interface React.js couvrant 8 à 10 écrans, avec des composants structurés en architecture réutilisable.",
                    "Optimisé les performances des requêtes SQL d’environ 20-30 % en concevant le schéma relationnel MySQL et en indexant les clés critiques.",
                    "Sécurisé une dizaine d’endpoints REST critiques avec des tests unitaires JUnit, pour une couverture d’environ 60-70 %.",
                    "Livré le projet dans les délais sur environ 8-10 sprints, en méthodologie Agile avec daily stand-ups, au sein d’une équipe de 3 à 5 personnes."
                ),
                List.of("Spring Boot", "Spring Cloud", "React.js", "MySQL", "JUnit", "Agile / Scrum", "Microservices")),
            new Experience(
                "Stage Développeur Web Full Stack (Laravel)",
                "Arti Web, Fès",
                "2022 – 2023 (2 mois)",
                List.of(
                    "Conçu une application de gestion de centre d’appel destinée à une dizaine d’agents et 2-3 administrateurs, avec un backend Laravel (PHP).",
                    "Modélisé un schéma relationnel MySQL normalisé de 6 à 8 tables, réduisant le temps de réponse des requêtes d’environ 15-20 % grâce à l’indexation des clés étrangères.",
                    "Développé 5-6 fonctionnalités back-end de gestion des agents et des administrateurs, avec les endpoints REST correspondants.",
                    "Testé et intégré l’interface utilisateur, avec une couverture fonctionnelle quasi complète des cas d’usage principaux, en méthodologie Agile."
                ),
                List.of("Laravel", "PHP", "MySQL", "Agile / Scrum"))
        );
    }

    @GetMapping("/projects")
    public List<Project> projects() {
        return List.of(
            new Project(
                "Application distribuée en microservices avec IA (PFE)",
                "Projet de fin d’études du Master : 4 microservices Spring Boot / Spring Cloud, "
              + "intégration de services d’IA via APIs REST pour automatiser 2 workflows métier, "
              + "et interface React.js de 8 à 10 écrans. Tests unitaires JUnit sur une dizaine "
              + "d’endpoints critiques.",
                List.of("Spring Boot", "Spring Cloud", "React.js", "MySQL", "JUnit"),
                null, null),
            new Project(
                "Système CRUD avec modélisation relationnelle",
                "Projet académique (FST Fès, 2022 – 2023) : conception et implémentation d’un "
              + "système CRUD reposant sur une modélisation relationnelle normalisée (UML / MERISE).",
                List.of("SQL", "UML", "MERISE"),
                null, null)
        );
    }

    @GetMapping("/skills")
    public List<SkillGroup> skills() {
        return List.of(
            new SkillGroup("Langages", List.of("Java 17", "PHP", "Python", "JavaScript", "C++")),
            new SkillGroup("Backend", List.of("Spring Boot", "Spring Security (JWT, OAuth2)",
                    "Spring Data JPA", "Spring Cloud", "Laravel", "Node.js")),
            new SkillGroup("Frontend", List.of("React.js", "HTML5", "CSS3")),
            new SkillGroup("Bases de données", List.of("MySQL", "SQL", "PL/SQL")),
            new SkillGroup("Build et tests", List.of("Maven", "JUnit")),
            new SkillGroup("Sécurité et documentation", List.of("OpenAPI / Swagger", "OWASP", "RGPD")),
            new SkillGroup("DevOps et outils", List.of("Docker", "Docker Compose", "Kubernetes (bases)",
                    "Git / GitHub", "CI/CD", "Linux")),
            new SkillGroup("Méthodologies", List.of("Agile / Scrum", "UML", "MERISE")),
            new SkillGroup("Langues", List.of("Arabe (langue maternelle)", "Français (courant)",
                    "Anglais (professionnel)"))
        );
    }
}