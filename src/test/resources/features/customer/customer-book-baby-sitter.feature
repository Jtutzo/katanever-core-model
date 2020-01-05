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
    Et Le baby-sitter "<login_babySitter>" est disponible le "<date_disponible>" pendant "<temps_disponible>"
    Quand Je reserve le baby-sitter "<login_babySitter>" le "<date_reservation>" pendant "<temps_reservation>"
    Alors La réservation est effective
    Et Le baby-sitter "<login_babySitter>" n'est plus disponible le "<date_reservation>" pendant "<temps_reservation>"
    Exemples:
      | login_customer | login_babySitter | date_disponible    | temps_disponible   | date_reservation      | temps_reservation |
      | jtutzo         | aMes             | 05/01/2020 - 8h00  | 8h                 | 05/01/2020 - 9h50     | 3h                |
      | mdupond        | bMartin          | 24/10/2020 - 14h30 | 5h                 | 24/10/2020 - 17h      | 2h                |
