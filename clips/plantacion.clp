
(defrule tierra-ideal                   ;TIERRA
(tierra ?x)
(or 
        (test (= ?x arcillosa))
        (test (= ?x limosa))
)
=>
(assert(tierra-es ideal))
(printout varTi "1" crlf)
)

(defrule tierra-desaconsejado
(tierra ?x)
(or 
        (test (= ?x arenosa))
        (test (= ?x negra))
)
=>
(assert(tierra-es desaconsejado))
(printout varTi "0.5" crlf)
)

(defrule tierra-inutil
(tierra ?x)
(test (= ?x otra))
=>
(assert(tierra-es inutil))
(printout varTi "0" crlf)
)

(defrule ph-ideal                       ;PH
(ph ?ph)
(and
        (test (>= ?ph 4))
        (test (<= ?ph 7))
)
=>
(assert (ph-es ideal))
(printout varPh "1" crlf)
)

(defrule ph-desaconsejado
(ph ?ph)
(or (and
        (test (> ?ph 3))
        (test (< ?ph 4))
    )
    (and
        (test (> ?ph 7))
        (test (< ?ph 8))
    )
)
=>
(assert (ph-es desaconsejado))
(printout varPh "0.5" crlf)
)

(defrule ph-inutil
(ph ?ph)
(or 
        (test (<= ?ph 3))
        (test (>= ?ph 8))

)
=>
(assert (ph-es inutil))
(printout varPh "0" crlf)
)

(defrule temperatura-ideal              ;TEMPERATURA
(temperatura ?tmp)
(test (= ?tmp 25))
=>
(assert (temperatura-es ideal))
(printout varTe "1" crlf)
)

(defrule temperatura-desaconsejado
(temperatura ?tmp)
(or (and
        (test (> ?tmp 21))
        (test (< ?tmp 25))
    )
    (and
        (test (> ?tmp 25))
        (test (< ?tmp 38))
    )
)
=>
(assert (temperatura-es desaconsejado))
(printout varTe "0.5" crlf)
)

(defrule temperatura-inutil
(temperatura ?tmp)
(or 
        (test (<= ?tmp 21))
        (test (>= ?tmp 38))
)
=>
(assert (temperatura-es inutil))
(printout varTe "0" crlf)
)

(defrule humedad-ideal                  ;HUMEDAD
(humedad ?h)
(test (= ?h 50))
=>
(assert (humedad-es ideal))
(printout varHu "1" crlf)
)

(defrule humedad-desaconsejado
(humedad ?h)
(or (and
        (test (> ?h 30))
        (test (< ?h 50))
    )
    (and
        (test (> ?h 50))
        (test (< ?h 70))
    )
)
=>
(assert (humedad-es desaconsejado))
(printout varHu "0.5" crlf)
)

(defrule temp-inutil
(humedad ?h)
(or 
        (test (<= ?h 30))
        (test (>= ?h 70))
)
=>
(assert (humedad-es inutil))
(printout varHu "0" crlf)
)

(defrule precipitacion-ideal                  ;PRECIPITACION
(precipitacion ?p)
(and
        (test (>= ?p 1500))
        (test (<= ?p 2500))
)
=>
(assert (precipitacion-es ideal))
(printout varPr "1" crlf)
)

(defrule precipitacion-desaconsejado
(precipitacion ?p)
(or (and
        (test (> ?p 1200))
        (test (< ?p 1500))
    )
    (and
        (test (> ?p 2500))
        (test (< ?p 3000))
    )
)
=>
(assert (precipitacion-es desaconsejado))
(printout varPr "0.5" crlf)
)

(defrule precipitacion-inutil
(precipitacion ?p)
(or 
        (test (<= ?p 1200))
        (test (>= ?p 3000))
)
=>
(assert (precipitacion-es inutil))
(printout varPr "0" crlf)
)

(defrule sombra-ideal                  ;SOMBRA
(sombra ?s)
(test (= ?s 50))
=>
(assert (sombra-es ideal))
(printout varSo "1" crlf)
)

(defrule sombra-desaconsejado
(sombra ?s)
(or (and
        (test (> ?s 40))
        (test (< ?s 50))
    )
    (and
        (test (> ?s 50))
        (test (< ?s 70))
    )
)
=>
(assert (sombra-es desaconsejado))
(printout varSo "0.5" crlf)
)

(defrule sombra-inutil
(sombra ?s)
(or 
        (test (<= ?s 40))
        (test (>= ?s 70))
)
=>
(assert (sombra-es inutil))
(printout varSo "0" crlf)
)

(defrule altitud-ideal                  ;ALTITUD
(altitud ?a)
(and
        (test (>= ?a 10))
        (test (<= ?a 400))
)
=>
(assert (altitud-es ideal))
(printout varAlti "1" crlf)
)

(defrule altitud-desaconsejado
(altitud ?a)
(or (and
        (test (> ?a 4))
        (test (< ?a 10))
    )
    (and
        (test (> ?a 400))
        (test (< ?a 1300))
    )
)
=>
(assert (altitud-es desaconsejado))
(printout varAlti "0.5" crlf)
)

(defrule altitud-inutil
(altitud ?a)
(or 
        (test (<= ?a 4))
        (test (>= ?a 1300))
)
=>
(assert (altitud-es inutil))
(printout varAlti "0" crlf)
)