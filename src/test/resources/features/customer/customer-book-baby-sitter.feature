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
    Et Le baby-sitter "<login_babySitter>" est disponible le "<jour_disponible>" pendant "<duree_disponible>"
    Quand Je reserve le baby-sitter "<login_babySitter>" le "<jour_reservation>" pendant "<duree_reservation>"
    Alors La réservation est effective
    Et Le baby-sitter "<login_babySitter>" n'est plus disponible le "<jour_reservation>" pendant "<duree_reservation>"
    Exemples:
      | login_customer | login_babySitter | jour_disponible  | duree_disponible | jour_reservation | duree_reservation |
      | jtutzo         | aMes             | 05/01/2020-08:00 | 08:00            | 05/01/2020-09:50 | 03:00             |
      | mdupond        | bMartin          | 24/10/2020-14:30 | 05:00            | 24/10/2020-14:30 | 02:00             |
      | fcorbella      | pDurand          | 12/09/2020-10:00 | 06:00            | 12/09/2020-13:00 | 03:00             |

  Plan du Scénario: Le baby-sitter est indisponible
    Etant donné Je suis authentifié en tant que "<login_customer>"
    Quand Je reserve le baby-sitter "<login_babySitter>" le "<jour_reservation>" pendant "<duree_reservation>"
    Alors La réservation n'est pas effective
    Et l'erreur "La baby-sitter n'est pas disponible pour cette période" est levée lors de la réservation
    Exemples:
      | login_customer | login_babySitter | jour_reservation | duree_reservation |
      | jtutzo         | aMes             | 05/01/2020-09:50 | 03:00             |
      | mdupond        | bMartin          | 24/10/2020-14:30 | 02:00             |
      | fcorbella      | pDurand          | 12/10/2020-13:00 | 03:00             |

  Plan du Scénario: Le baby-sitter est déja réservé
    Etant donné Je suis authentifié en tant que "<customer>"
    Et Le baby-sitter "<babySitter>" est disponible le "<jour_disponible>" pendant "<duree_disponible>"
    Et le baby-sitter "<babySitter>" est déja réservé le "<jour_deja_reserve>" pendant "<duree_deja_reserve>"
    Quand Je reserve le baby-sitter "<babySitter>" le "<jour_reservation>" pendant "<duree_reservation>"
    Alors La réservation n'est pas effective
    Et l'erreur "La baby-sitter n'est pas disponible pour cette période" est levée lors de la réservation
    Exemples:
      | customer  | babySitter | jour_disponible  | duree_disponible | jour_deja_reserve | duree_deja_reserve | jour_reservation | duree_reservation |
      | jtutzo    | aMes       | 05/01/2020-08:00 | 08:00            | 05/01/2020-08:00  | 02:00              | 05/01/2020-09:50 | 03:00             |
      | mdupond   | bMartin    | 24/10/2020-14:30 | 05:00            | 24/10/2020-14:30  | 05:00              | 24/10/2020-14:30 | 02:00             |
      | fcorbella | pDurand    | 12/09/2020-08:00 | 10:00            | 12/09/2020-10:00  | 06:00              | 12/10/2020-08:00 | 03:00             |
