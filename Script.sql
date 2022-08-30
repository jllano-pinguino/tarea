create table Tarea(
  id_t number,
  descripcion number,
  estado char,
  constraint p_key primary key (id_t) 
)
/
select * from Tarea;
/
drop table Tarea;
