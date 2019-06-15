select id_viaje, dni_conductor, l1.nombre_localidad origen, l2.nombre_localidad destino, plazas_disponibles from viajes
inner join localidad l1 on viajes.id_origen=l1.id_localidad inner join localidad l2 on viajes.id_destino=l2.id_localidad 
where id_origen=1 and id_destino=2;

select id_viaje, dni_conductor, l1.nombre_localidad origen, l2.nombre_localidad destino, plazas_disponibles from viajes
inner join localidad l1 on viajes.id_origen=l1.id_localidad inner join localidad l2 on viajes.id_destino=l2.id_localidad 
where id_origen=6 and id_destino=7;