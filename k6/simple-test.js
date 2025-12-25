import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 30,            // 동시 사용자 수
  duration: '30s',    // 테스트 시간
};

export default function () {
  http.get(
      'http://host.docker.internal:8080/admin/orders/summary' +
      '?from=2000-01-01T00:00:00&to=2099-12-31T23:59:59'
  );
  sleep(1);
}
