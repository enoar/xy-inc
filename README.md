Readme.

1 - O projeto foi feito em java 8 utilizando o Vraptor 4. <br>
2 - Para a persistencia utilizei o Hibernate. Todo o controller de conexões é feito pelo Vraptor.<br>
3 - Para os testes utilizei JUnit + mockito. Todos os três serviços possuem testes em seus respectivos controllers. Por se ter uma baixa complexidade optei por fazer os testes unitarios apenas nos controllers.<br>
4 - Apesar de não haver na documentação explicidamente que não poderia haver dois estabelecimentos no mesmo endereço implementei uma lógica no serviço para evitar que isso ocorra.<br>
5 - A configuração do arquivo do hibernate.cfg (hibernate.hbm2ddl.auto) está setado para "created" para produção essa configuração deve está como validate.
