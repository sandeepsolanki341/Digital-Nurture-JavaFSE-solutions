# HOL 18 - Unit Testing with Jest & Enzyme

**Duration:** 90 minutes

## Objective

Install and configure Enzyme, write unit tests, and capture component snapshots.

## Topics Covered

- Jest test framework
- Enzyme (mount, shallow)
- describe(), test() blocks
- Component snapshot testing

## Exercise

Unit test the Cohort Dashboard application using Enzyme. Test the `CohortDetails` component to ensure it renders correctly.

## Steps

```bash
# Install Enzyme and adapter
npm install --save-dev enzyme enzyme-adapter-react-16
```

### Solution

#### `src/setupTests.js`

```jsx
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });
```

#### `src/Cohort.js`

```jsx
const CohortData = [
  { name: 'GenC Cohort 1', status: 'completed', trainer: 'John', participants: 30 },
  { name: 'GenC Cohort 2', status: 'ongoing', trainer: 'Jane', participants: 25 },
  { name: 'GenC Cohort 3', status: 'ongoing', trainer: 'Smith', participants: 28 }
];

export default CohortData;
```

#### `src/CohortDetails.test.js`

```jsx
import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import CohortData from './Cohort';

describe('CohortDetails Component', () => {

  test('should render without crashing', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  test('should display cohort name', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.find('h3').text()).toBe('GenC Cohort 1');
  });

  test('should display correct status', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.text()).toContain('completed');
  });

  test('should apply green color for ongoing cohorts', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[1]} />);
    const h3Style = wrapper.find('h3').prop('style');
    expect(h3Style.color).toBe('green');
  });

  test('should apply blue color for completed cohorts', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    const h3Style = wrapper.find('h3').prop('style');
    expect(h3Style.color).toBe('blue');
  });

  test('should match snapshot', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper).toMatchSnapshot();
  });
});
```

```bash
# Run tests
npm test
```
