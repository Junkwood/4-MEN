
CREATE TABLE bom
(
	bom_code             VARCHAR2(30) NOT NULL ,
	mat_code             VARCHAR2(30) NOT NULL ,
	use_amount           NUMBER(10) NULL ,
	note                 VARCHAR2(300) NULL ,
	prod_code            VARCHAR2(30) NOT NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE bom
	ADD  PRIMARY KEY (bom_code);



CREATE TABLE emp
(
	emp_code             VARCHAR2(30) NOT NULL ,
	password             VARCHAR2(80) NOT NULL ,
	emp_name             VARCHAR2(15) NOT NULL ,
	tel                  VARCHAR2(20) NULL ,
	email                VARCHAR2(50) NULL ,
	rank                 VARCHAR2(15) NULL ,
	birth_date           DATE NOT NULL ,
	ent_member_code      VARCHAR2(30) NULL ,
	dept_id              VARCHAR2(15) NULL 
);



ALTER TABLE emp
	ADD  PRIMARY KEY (emp_code);



CREATE TABLE ent_member
(
	ent_member_code      VARCHAR2(30) NULL ,
	member_id            VARCHAR2(20) NULL ,
	password             VARCHAR2(80) NOT NULL ,
	business_number      VARCHAR2(15) NOT NULL ,
	tel                  VARCHAR2(20) NULL ,
	email                VARCHAR2(50) NOT NULL ,
	ceo_name             VARCHAR2(15) NULL ,
	sub_status           CHAR(1) NULL ,
	ent_name             VARCHAR2(30) NULL ,
	address              VARCHAR2(100) NULL 
);



ALTER TABLE ent_member
	ADD  PRIMARY KEY (ent_member_code);



CREATE TABLE fac
(
	fac_code             VARCHAR2(30) NOT NULL ,
	fac_name             VARCHAR2(30) NULL ,
	manufacture_date     DATE NULL ,
	install_date         DATE NULL ,
	inspect_cycle        NUMBER(5) NULL ,
	fac_status           VARCHAR2(15) NULL ,
	image                VARCHAR2(300) NULL ,
	upload_path          VARCHAR2(300) NULL ,
	fac_class_code       VARCHAR2(30) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE fac
	ADD  PRIMARY KEY (fac_code);



CREATE TABLE fac_insp
(
	fac_insp_code        VARCHAR2(30) NOT NULL ,
	fac_code             VARCHAR2(30) NOT NULL ,
	registration_date    DATE DEFAULT  SYSDATE  NULL ,
	process_date         DATE NULL ,
	process_history      VARCHAR2(300) NULL ,
	process_result       VARCHAR2(30) NULL ,
	insp_class_code      VARCHAR2(30) NULL ,
	note                 VARCHAR2(300) NULL ,
	next_insp_date       DATE NULL ,
	emp_code             VARCHAR2(15) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE fac_insp
	ADD  PRIMARY KEY (fac_insp_code);



CREATE TABLE fac_not
(
	fac_not_code         VARCHAR2(30) NOT NULL ,
	fac_code             VARCHAR2(30) NOT NULL ,
	emp_code             VARCHAR2(15) NULL ,
	not_start_date       DATE NULL ,
	not_end_date         DATE NULL ,
	fac_not_reason_code  VARCHAR2(30) NULL ,
	note                 VARCHAR2(300) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE fac_not
	ADD  PRIMARY KEY (fac_not_code);



CREATE TABLE manu_plan
(
	manu_plan_code       VARCHAR2(30) NOT NULL ,
	order_code           VARCHAR2(30) NULL ,
	plan_name            VARCHAR2(30) NULL ,
	emp_code             VARCHAR2(15) NULL ,
	registration_date    DATE DEFAULT  SYSDATE  NULL ,
	start_date           DATE DEFAULT  SYSDATE  NULL ,
	end_date             DATE DEFAULT  SYSDATE  NULL ,
	note                 VARCHAR2(300) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE manu_plan
	ADD  PRIMARY KEY (manu_plan_code);



CREATE TABLE manu_plan_detail
(
	manu_plan_detail_code VARCHAR2(30) NOT NULL ,
	manu_plan_code       VARCHAR2(30) NOT NULL ,
	prod_code            VARCHAR2(30) NULL ,
	plan_quantity        NUMBER(10) NULL ,
	priority             NUMBER(5) NULL ,
	process_status       VARCHAR2(15) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE manu_plan_detail
	ADD  PRIMARY KEY (manu_plan_detail_code);



CREATE TABLE mat_common
(
	mat_code             VARCHAR2(30) NOT NULL ,
	mat_class            VARCHAR2(15) NULL ,
	mat_name             VARCHAR2(30) NULL ,
	standard             VARCHAR2(100) NULL ,
	unit                 VARCHAR2(10) NULL ,
	safetystock          NUMBER(10) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE mat_common
	ADD  PRIMARY KEY (mat_code);



CREATE TABLE mat_hold
(
	mat_hold_code        VARCHAR2(30) NOT NULL ,
	LOT                  VARCHAR2(30) NULL ,
	work_instruct_detail_code VARCHAR2(30) NULL ,
	hold_quantity        NUMBER(10) NULL ,
	progress             VARCHAR2(12) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE mat_hold
	ADD  PRIMARY KEY (mat_hold_code);



CREATE TABLE mat_inspect
(
	mat_inspect_code     VARCHAR2(30) NOT NULL ,
	mat_order_detail_code VARCHAR2(30) NOT NULL ,
	inspect_quantity     NUMBER(10) NULL ,
	error_quantity       NUMBER(10) NULL ,
	inspect_date         DATE NULL ,
	note                 VARCHAR2(300) NULL ,
	emp_code             VARCHAR2(15) NULL ,
	pass_quantity        NUMBER(10) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE mat_inspect
	ADD  PRIMARY KEY (mat_inspect_code);



CREATE TABLE mat_order
(
	mat_order_code       VARCHAR2(30) NOT NULL ,
	order_name           VARCHAR2(30) NULL ,
	order_date           DATE NULL ,
	emp_code             VARCHAR2(15) NULL ,
	order_status         VARCHAR2(20) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE mat_order
	ADD  PRIMARY KEY (mat_order_code);







CREATE TABLE mat_release
(
	mat_release_code     VARCHAR2(30) NOT NULL ,
	release_date         DATE NULL ,
	release_quantity     NUMBER(10) NULL ,
	work_instruct_detail_code VARCHAR2(30) NULL ,
	mat_hold_code        VARCHAR2(30) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE mat_release
	ADD  PRIMARY KEY (mat_release_code);







CREATE TABLE mes_main_code
(
	main_code            CHAR(4) NOT NULL ,
	ent_member_code      VARCHAR2(30) NULL ,
	main_code_name       VARCHAR2(30) NULL 
);



ALTER TABLE mes_main_code
	ADD  PRIMARY KEY (main_code);



CREATE TABLE mes_sub_code
(
	sub_code             CHAR(4) NOT NULL ,
	main_code            CHAR(4) NOT NULL ,
	sub_code_name        VARCHAR2(30) NULL 
);



ALTER TABLE mes_sub_code
	ADD  PRIMARY KEY (sub_code);



CREATE TABLE order_detail
(
	order_detail_code    VARCHAR2(30) NOT NULL ,
	order_code           VARCHAR2(30) NOT NULL ,
	prod_code            VARCHAR2(30) NULL ,
	order_quantity       NUMBER(10) NULL ,
	process_status       VARCHAR2(15) DEFAULT  default 'PS1' NOT NULL ,
	ent_member_code      VARCHAR2(30) NULL ,
    order_price          NUMBER(10) NOT NULL
);



ALTER TABLE order_detail
	ADD  PRIMARY KEY (order_detail_code);



CREATE TABLE orders
(
	order_code           VARCHAR2(30) NOT NULL ,
	order_name           VARCHAR2(30) NOT NULL ,
	emp_code             VARCHAR2(15) NOT NULL ,
	registration_date    DATE DEFAULT  SYSDATE  NULL ,
	due_date             DATE DEFAULT  SYSDATE  NULL ,
	note                 VARCHAR2(300) NULL ,
	ent_member_code      VARCHAR2(30) NULL ,
	client_code          VARCHAR2(30) NULL 
);



ALTER TABLE orders
	ADD  PRIMARY KEY (order_code);



CREATE TABLE perf
(
	perf_code            VARCHAR2(30) NOT NULL ,
	work_progress_code   VARCHAR2(30) NOT NULL ,
	work_start_date      DATE DEFAULT  SYSDATE  NULL ,
	work_end_date        DATE DEFAULT  SYSDATE  NULL ,
	input_quantity       NUMBER(10) NULL ,
	error_quantity       NUMBER(10) NULL ,
	prod_quantity        NUMBER(10) NULL ,
	worker               VARCHAR2(15) NULL ,
	fac_code             VARCHAR2(30) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE perf
	ADD  PRIMARY KEY (perf_code);



CREATE TABLE proc
(
	proc_code            VARCHAR2(30) NOT NULL ,
	proc_name            VARCHAR2(30) NULL ,
	note                 VARCHAR2(300) NULL ,
	fac_class_code       VARCHAR2(30) NULL ,
	proc_class_code      VARCHAR2(30) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE proc
	ADD  PRIMARY KEY (proc_code);



CREATE TABLE proc_flow
(
	proc_num             NUMBER(5) NULL ,
	proc_code            VARCHAR2(30) NULL ,
	proc_flow_code       VARCHAR2(30) NOT NULL ,
	prod_code            VARCHAR2(30) NULL ,
	proc_name            VARCHAR2(30) NULL ,
	note                 VARCHAR2(300) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE proc_flow
	ADD  PRIMARY KEY (proc_flow_code);



CREATE TABLE prod_common
(
	prod_name            VARCHAR2(30) NULL ,
	unit                 VARCHAR2(10) NULL ,
	standard             VARCHAR2(100) NULL ,
	prod_code            VARCHAR2(30) NOT NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE prod_common
	ADD  PRIMARY KEY (prod_code);



CREATE TABLE prod_release
(
	prod_release_code    VARCHAR2(30) NOT NULL ,
	order_code           VARCHAR2(30) NULL ,
	LOT                  VARCHAR2(30) NOT NULL ,
	release_quantity     NUMBER(10) NULL ,
	release_date         DATE DEFAULT  SYSDATE  NULL ,
	emp_code             VARCHAR2(15) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE prod_release
	ADD  PRIMARY KEY (prod_release_code);



CREATE TABLE prod_store
(
	LOT                  VARCHAR2(30) NOT NULL ,
	work_instruct_detail_code VARCHAR2(30) NOT NULL ,
	prod_code            VARCHAR2(30) NULL ,
	store_quantity       NUMBER(10) NULL ,
	store_date           DATE DEFAULT  SYSDATE  NULL ,
	emp_code             VARCHAR2(15) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE prod_store
	ADD  PRIMARY KEY (LOT);



CREATE TABLE pur_history
(
	pur_history_code     VARCHAR2(30) NOT NULL ,
	pur_date             DATE DEFAULT  SYSDATE  NULL ,
	pur_payment          VARCHAR2(15) NULL ,
	pur_price            NUMBER(10) NULL ,
	ent_member_code      VARCHAR2(30) NULL ,
	sub_start_date       DATE DEFAULT  SYSDATE  NULL ,
	sub_end_date         DATE DEFAULT  SYSDATE  NULL ,
	next_pur_date        DATE NULL ,
	sub_goods_code       VARCHAR2(30) NULL 
);



ALTER TABLE pur_history
	ADD  PRIMARY KEY (pur_history_code);



CREATE TABLE rep
(
	rep_no               VARCHAR2(30) NOT NULL ,
	fac_code             VARCHAR2(30) NOT NULL ,
	rep_request_date     DATE NULL ,
	rep_process_date     DATE NULL ,
	rep_history          VARCHAR2(300) NULL ,
	breakdown            VARCHAR2(300) NULL ,
	rep_class_code       VARCHAR2(30) NULL ,
	note                 VARCHAR2(300) NULL ,
	rep_requester        VARCHAR2(15) NULL ,
	rep_manager          VARCHAR2(15) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE rep
	ADD  PRIMARY KEY (rep_no);



CREATE TABLE sub_goods
(
	sub_goods_code       VARCHAR2(30) NOT NULL ,
	goods_name           VARCHAR2(20) NULL ,
	goods_price          NUMBER(10) NULL 
);



ALTER TABLE sub_goods
	ADD  PRIMARY KEY (sub_goods_code);



CREATE TABLE sub_main_code
(
	main_code            CHAR(4) NOT NULL ,
	main_code_name       VARCHAR2(30) NOT NULL 
);



ALTER TABLE sub_main_code
	ADD  PRIMARY KEY (main_code);



CREATE TABLE sub_sub_code
(
	sub_code             CHAR(4) NOT NULL ,
	main_code            CHAR(4) NOT NULL ,
	sub_code_name        VARCHAR2(30) NULL 
);



ALTER TABLE sub_sub_code
	ADD  PRIMARY KEY (sub_code);



CREATE TABLE test
(
	test_code            VARCHAR2(30) NOT NULL ,
	test_name            VARCHAR2(20) NULL ,
	test_item            VARCHAR2(20) NULL ,
	test_item_unit       VARCHAR2(20) NULL ,
	note                 VARCHAR2(300) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE test
	ADD  PRIMARY KEY (test_code);



CREATE TABLE test_flow
(
	test_num             NUMBER(5) NOT NULL ,
	test_code            VARCHAR2(30) NOT NULL ,
	pass_criteria        VARCHAR2(15) NULL ,
	note                 VARCHAR2(300) NULL ,
	proc_flow_code       VARCHAR2(30) NOT NULL ,
	test_flow_code       VARCHAR2(30) NOT NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE test_flow
	ADD  PRIMARY KEY (test_flow_code);



CREATE TABLE test_process
(
	test_process_code    VARCHAR2(30) NOT NULL ,
	work_progress_code   VARCHAR2(30) NOT NULL ,
	test_quantity        NUMBER(5) NULL ,
	error_quantity       NUMBER(5) NULL ,
	test_date            DATE DEFAULT  SYSDATE  NULL ,
	registration_date    DATE DEFAULT  SYSDATE  NULL ,
	emp_code             VARCHAR2(15) NULL ,
	note                 VARCHAR2(300) NULL ,
	test_flow_code       VARCHAR2(30) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE test_process
	ADD  PRIMARY KEY (test_process_code);



CREATE TABLE work_instruct
(
	work_instruct_code   VARCHAR2(30) NOT NULL ,
	manu_plan_code       VARCHAR2(30) NULL ,
	work_name            VARCHAR2(30) NULL ,
	emp_code             VARCHAR2(15) NULL ,
	registration_date    DATE DEFAULT  SYSDATE  NULL ,
	manu_start_date      DATE DEFAULT  SYSDATE  NULL ,
	manu_end_date        DATE DEFAULT  SYSDATE  NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE work_instruct
	ADD  PRIMARY KEY (work_instruct_code);



CREATE TABLE work_instruct_detail
(
	work_instruct_detail_code VARCHAR2(30) NOT NULL ,
	work_instruct_code   VARCHAR2(30) NOT NULL ,
	prod_code            VARCHAR2(30) NULL ,
	instruct_quantity    NUMBER(10) NULL ,
	priority             NUMBER(5) NULL ,
	process_status       VARCHAR2(15) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE work_instruct_detail
	ADD  PRIMARY KEY (work_instruct_detail_code);



CREATE TABLE work_progress
(
	work_progress_code   VARCHAR2(30) NOT NULL ,
	proc_code            VARCHAR2(30) NOT NULL ,
	work_instruct_detail_code VARCHAR2(30) NOT NULL ,
	proc_num             NUMBER(5) NULL ,
	instruct_quantity    NUMBER(10) NULL ,
	input_quantity       NUMBER(10) NULL ,
	error_quantity       NUMBER(10) NULL ,
	prod_quantity        NUMBER(10) NULL ,
	progress             CHAR(1) NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);



ALTER TABLE work_progress
	ADD  PRIMARY KEY (work_progress_code);



ALTER TABLE bom
	ADD (FOREIGN KEY (mat_code) REFERENCES mat_common (mat_code));



ALTER TABLE bom
	ADD (FOREIGN KEY (prod_code) REFERENCES prod_common (prod_code));



ALTER TABLE emp
	ADD (FOREIGN KEY (ent_member_code) REFERENCES ent_member (ent_member_code));



ALTER TABLE fac_insp
	ADD (FOREIGN KEY (fac_code) REFERENCES fac (fac_code));



ALTER TABLE fac_not
	ADD (FOREIGN KEY (fac_code) REFERENCES fac (fac_code));



ALTER TABLE manu_plan
	ADD (FOREIGN KEY (order_code) REFERENCES orders (order_code));



ALTER TABLE manu_plan_detail
	ADD (FOREIGN KEY (manu_plan_code) REFERENCES manu_plan (manu_plan_code));



ALTER TABLE mat_hold
	ADD (FOREIGN KEY (LOT) REFERENCES mat_store (LOT));



ALTER TABLE mat_hold
	ADD (FOREIGN KEY (work_instruct_detail_code) REFERENCES work_instruct_detail (work_instruct_detail_code));



ALTER TABLE mat_inspect
	ADD (FOREIGN KEY (mat_order_detail_code) REFERENCES mat_order_detail (mat_order_detail_code));



ALTER TABLE mat_order_detail
	ADD (FOREIGN KEY (mat_code) REFERENCES mat_common (mat_code));



ALTER TABLE mat_order_detail
	ADD (FOREIGN KEY (mat_order_code) REFERENCES mat_order (mat_order_code));



ALTER TABLE mat_release
	ADD (FOREIGN KEY (work_instruct_detail_code) REFERENCES work_instruct_detail (work_instruct_detail_code));



ALTER TABLE mat_release
	ADD (FOREIGN KEY (mat_hold_code) REFERENCES mat_hold (mat_hold_code));








ALTER TABLE mes_main_code
	ADD (FOREIGN KEY (ent_member_code) REFERENCES ent_member (ent_member_code));



ALTER TABLE mes_sub_code
	ADD (FOREIGN KEY (main_code) REFERENCES mes_main_code (main_code));



ALTER TABLE order_detail
	ADD (FOREIGN KEY (order_code) REFERENCES orders (order_code));



ALTER TABLE perf
	ADD (FOREIGN KEY (work_progress_code) REFERENCES work_progress (work_progress_code));



ALTER TABLE proc_flow
	ADD (FOREIGN KEY (proc_code) REFERENCES proc (proc_code));



ALTER TABLE proc_flow
	ADD (FOREIGN KEY (prod_code) REFERENCES prod_common (prod_code));



ALTER TABLE prod_release
	ADD (FOREIGN KEY (LOT) REFERENCES prod_store (LOT));



ALTER TABLE prod_release
	ADD (FOREIGN KEY (order_code) REFERENCES orders (order_code));



ALTER TABLE prod_store
	ADD (FOREIGN KEY (work_instruct_detail_code) REFERENCES work_instruct_detail (work_instruct_detail_code));



ALTER TABLE pur_history
	ADD (FOREIGN KEY (ent_member_code) REFERENCES ent_member (ent_member_code));



ALTER TABLE pur_history
	ADD (FOREIGN KEY (sub_goods_code) REFERENCES sub_goods (sub_goods_code));



ALTER TABLE rep
	ADD (FOREIGN KEY (fac_code) REFERENCES fac (fac_code));



ALTER TABLE sub_sub_code
	ADD (FOREIGN KEY (main_code) REFERENCES sub_main_code (main_code));



ALTER TABLE test_flow
	ADD (FOREIGN KEY (proc_flow_code) REFERENCES proc_flow (proc_flow_code));



ALTER TABLE test_flow
	ADD (FOREIGN KEY (test_code) REFERENCES test (test_code));



ALTER TABLE test_process
	ADD (FOREIGN KEY (work_progress_code) REFERENCES work_progress (work_progress_code));



ALTER TABLE test_process
	ADD (FOREIGN KEY (test_flow_code) REFERENCES test_flow (test_flow_code));



ALTER TABLE work_instruct
	ADD (FOREIGN KEY (manu_plan_code) REFERENCES manu_plan (manu_plan_code));



ALTER TABLE work_instruct_detail
	ADD (FOREIGN KEY (work_instruct_code) REFERENCES work_instruct (work_instruct_code));



ALTER TABLE work_progress
	ADD (FOREIGN KEY (work_instruct_detail_code) REFERENCES work_instruct_detail (work_instruct_detail_code));



ALTER TABLE work_progress
	ADD (FOREIGN KEY (proc_code) REFERENCES proc (proc_code));

CREATE TABLE client
(
	client_code    VARCHAR2(30) NOT NULL ,
	client_name    VARCHAR2(30) NOT NULL ,
    client_type    VARCHAR2(15) NOT NULL ,
    tel            VARCHAR2(20) NULL ,
    address        VARCHAR2(100) NULL ,
    client_manager VARCHAR2(15) NULL ,
    ent_member_code VARCHAR2(30) NULL
);
ALTER TABLE client
	ADD  PRIMARY KEY (client_code);
ALTER TABLE orders
	ADD (FOREIGN KEY (client_code) REFERENCES client (client_code));

CREATE TABLE mat_store
(
	LOT                  VARCHAR2(30) NOT NULL ,
	mat_code             VARCHAR2(30) NULL ,
	store_quantity       NUMBER(10) NULL ,
	store_date           DATE NULL ,
	emp_code             VARCHAR2(15) NULL ,
	ent_member_code      VARCHAR2(30) NULL ,
    mat_inspect_code     VARCHAR2(30) NULL 
);


ALTER TABLE mat_store
	ADD  PRIMARY KEY (LOT);
    
ALTER TABLE mat_store
	ADD (FOREIGN KEY (mat_inspect_code) REFERENCES mat_inspect (mat_inspect_code));

CREATE TABLE mat_order_detail
(
	mat_order_detail_code VARCHAR2(30) NOT NULL ,
	mat_order_code       VARCHAR2(30) NOT NULL ,
	mat_code             VARCHAR2(30) NOT NULL ,
	client_name          VARCHAR2(30) NULL ,
	quantity             NUMBER(10) NULL ,
	delivery_date        DATE NULL ,
	ent_member_code      VARCHAR2(30) NULL 
);


ALTER TABLE mat_order_detail
	ADD  PRIMARY KEY (mat_order_detail_code);
