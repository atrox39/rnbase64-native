
import { NativeModules } from 'react-native';

const { RNBase64Native } = NativeModules;

export default {
  filePicker: RNBase64Native.filePicker,
};
