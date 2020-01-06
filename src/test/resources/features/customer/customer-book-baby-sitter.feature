# language: fr
Fonctionnalité: Tout client - réserver un babysitter

  Un client veut réserver un babysitter à fin de garder ses enfants.

  Contexte:
    Etant donné des clients existent:
      | login     | firstName | lastName |
      | jtutzo    | Jérémy    | Tutzo    |
      | fcorbella | Francesca | Corbella |
      | mdupond   | Martin    | Dupond   |

    Etant donné des baby-sitters existent:
      | login     | firstName | lastName |
      | bMartin   | Benjamin  | Martin   |
      | aMes      | Antoine   | Mes      |
      | pDurand   | Pauline   | Durand   |

  Plan du Scénario: Le baby-sitter est disponible
    Etant donné Je suis authentifié en tant que "<login_customer>"
    Et Le baby-sitter "<login_babySitter>" est disponible le "<jour_disponible>" à "<heure_disponible>" pendant "<duree_disponible>"
    Quand Je reserve le baby-sitter "<login_babySitter>" le "<jour_reservation>" à "<heure_reservation>" pendant "<duree_reservation>"
    Alors La réservation est effective
    Et Le baby-sitter "<login_babySitter>" n'est plus disponible le "<jour_reservation>" à "<heure_reservation>" pendant "<duree_reservation>"
    Exemples:
      | login_customer | login_babySitter | jour_disponible | heure_disponible |duree_disponible | jour_reservation | heure_reservation | duree_reservation |
      | jtutzo         | aMes             | 05/01/2020      | 08:00            | 08:00           | 05/01/2020       | 09:50             | 03:00             |
      | mdupond        | bMartin          | 24/10/2020      | 14:30            | 05:00           | 24/10/2020       | 17:00             | 02:00             |
