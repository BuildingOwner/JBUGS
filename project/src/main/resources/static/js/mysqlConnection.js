const mysql = require('mysql');

const connection = mysql.createConnection({
    host: '13.125.120.116:3306',
    user: 'jbugs',
    password: '1234',
    database: 'webdb'
});

connection.connect((err) => {
    if (err) {
        console.error('MySQL 연결 오류: ' + err.stack);
        return;
    }
    console.log('MySQL에 연결되었습니다.');
});
