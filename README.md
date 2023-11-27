# Car Shop

Super car shop.

### Description

Learning Spring Data JPA PostgreSQL queries.

---

### Add Engine

```
{
    "engineType": "electric",
    "horsePower": "150",
    "make": "Mazda"
}
```

- Basic validation;
- CRUD operations;
- Custom queries ( `List<Engine> findByHorsePowerGreaterThanEqual(int horsePower)`, etc.);
- get mapping with parameters(`ResponseEntity<List<EngineDTO>> getEnginesByHorsePowerGreaterThanEqual(@RequestParam Map<String, String> params)`);

---

### Team Members

- [Ionuț Dragomirescu](https://github.com/dragomirescuionut)
- [Anghel Andrei](https://github.com/rhacp)
- [Dan Ionescu](https://github.com/Daniel7Ionescu)
- [Gabriella Nuca](https://github.com/GabriellaNuca2209)
